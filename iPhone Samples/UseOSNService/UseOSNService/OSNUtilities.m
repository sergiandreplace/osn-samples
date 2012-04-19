//
//  OSNUtilities.m
//  UseOSNService
//
//  Created by Luis Lopez on 27/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "OSNUtilities.h"

@interface OSNUtilities ()

@end


@implementation OSNUtilities

@synthesize delegate, jsonFetcher, xmlFetcher;

- (void)receiveResponse:(HTTPFetcher *)aFetcher
{
    NSMutableDictionary *errorDetail = [NSMutableDictionary dictionary];
    NSError * error = [NSError errorWithDomain:@"myDomain" code:100 userInfo:errorDetail];
    
    if ([aFetcher class] == [XMLFetcher class]) {
        if ([xmlFetcher.data length] > 0)
        {
            NSLog(@"XML data received: %@", xmlFetcher.results);
            
        } else {
            if (delegate!= nil && [delegate respondsToSelector:@selector(receivedServiceMetaDataWithError:)]) {
                [errorDetail setValue:@"no XML file" forKey:NSLocalizedDescriptionKey];
                [self.delegate receivedServiceResponseWithError:error];
            }
        }
    } else if ([aFetcher class] == [JSONFetcher class]) {
        if ([jsonFetcher.data length] > 0)
        {
            NSLog(@"JSON data received: %@", jsonFetcher.result);
            //check witch kind of response
            NSDictionary * serviceDictionary = [(NSDictionary *)jsonFetcher.result objectForKey:@"service"];
            if (serviceDictionary == nil) {
                OSNService * service = [[OSNService alloc] initWithDictionary:serviceDictionary];
                if (delegate!= nil && [delegate respondsToSelector:@selector(receivedServiceMetaDataResponse:)]) {
                    
                    [self.delegate receivedServiceMetaDataResponse:service];
                }
                
            } 
        } else {
            NSDictionary * serviceDictionary = [(NSDictionary *)jsonFetcher.result objectForKey:@"entry"];
            if (serviceDictionary == nil) {
                OSNEntry * entry = [[OSNEntry alloc] initWithDictionary:serviceDictionary];
                if (delegate!= nil && [delegate respondsToSelector:@selector(receivedServiceMetaDataResponse:)]) {
                    
                    [self.delegate receivedServiceDataResponse:entry];
                }
            }    
        }
    }else {
        if (delegate!= nil && [delegate respondsToSelector:@selector(receivedServiceMetaDataWithError:)]) {
            [errorDetail setValue:@"no JSON file" forKey:NSLocalizedDescriptionKey];
            [self.delegate receivedServiceResponseWithError:error];
        }
    }
}


-(void)getJSONServiceMetadataWithStringURL:(NSString *)url {
    
    jsonFetcher = [[JSONFetcher alloc]
                   initWithURLString:[NSString stringWithFormat:@"%@",url]
                   receiver:self
                   action:@selector(receiveResponse:)];
    [jsonFetcher start];
    
}

-(void)getXMLServiceMetadataWithStringURL:(NSString *)url {
    
}

-(void)getJSONServiceDataWithStringURL:(NSString *)url {
    
    [self getJSONServiceMetadataWithStringURL:url];
    
}

-(void)getXMLServiceDataWithStringURL:(NSString *)url {
    
}

@end
