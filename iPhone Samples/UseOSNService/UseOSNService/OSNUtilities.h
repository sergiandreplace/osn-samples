//
//  OSNUtilities.h
//  UseOSNService
//
//  Created by Luis Lopez on 27/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "OSN.h"
#import "XMLFetcher.h"
#import "JSONFetcher.h"

@protocol OSNUtilitiesDelegate <NSObject>

@optional
-(void)receivedServiceMetaDataResponse:(OSNService *)response;
-(void)receivedServiceDataResponse:(OSNEntry *)response;
-(void)receivedServiceResponseWithError:(NSError *)error;

@end

@interface OSNUtilities : NSObject {
    
    JSONFetcher * jsonFetcher;
    XMLFetcher * xmlFetcher;
    id<OSNUtilitiesDelegate>delegate;
}

@property(nonatomic,strong) JSONFetcher * jsonFetcher;
@property(nonatomic,strong) XMLFetcher * xmlFetcher;
@property(nonatomic,strong) id<OSNUtilitiesDelegate>delegate;

-(void)getJSONServiceMetadataWithStringURL:(NSString *)url;
-(void)getXMLServiceMetadataWithStringURL:(NSString *)url;
-(void)getJSONServiceDataWithStringURL:(NSString *)url;
-(void)getXMLServiceDataWithStringURL:(NSString *)url;

@end
