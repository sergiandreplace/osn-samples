//
//  ViewController.m
//  UseOSNService
//
//  Created by Luis Lopez on 22/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "ViewController.h"
#import "SBJsonParser.h"
#import "OSN.h"

@interface ViewController ()

@end

@implementation ViewController

@synthesize XMLfetcher, JSONfetcher;

-(void)setViewWithService:(OSNService *)service {
    
    [titleLabel setText:@"OSN Metadata service"];
    
    [serviceIDLabel setText:[NSString stringWithFormat:@"%@%@",serviceIDLabel.text, service.idService]];
    [nameLabel setText:[NSString stringWithFormat:@"%@%@",nameLabel.text, service.name]];
    [authorLabel setText:[NSString stringWithFormat:@"%@%@",authorLabel.text, service.author]];
    [descriptionLabel setText:[NSString stringWithFormat:@"%@%@",descriptionLabel.text, service.description]];
    [emailLabel setText:[NSString stringWithFormat:@"%@%@",emailLabel.text, service.email]];
    [groupLabel setText:[NSString stringWithFormat:@"%@%@",groupLabel.text, service.group]];
    [latitudeLabel setText:[NSString stringWithFormat:@"%@%@",latitudeLabel.text, service.latitude]];
    [longitudeLabel setText:[NSString stringWithFormat:@"%@%@",longitudeLabel.text, service.longitude]];
    [twitterLabel setText:[NSString stringWithFormat:@"%@%@",twitterLabel.text, service.twitter_account]];
    [updateLabel setText:[NSString stringWithFormat:@"%@%@",updateLabel.text, service.update_period]];
    [urlLabel setText:[NSString stringWithFormat:@"%@%@",urlLabel.text, service.url]];
    [tagLabel setText:[NSString stringWithFormat:@"%@%@",tagLabel.text, service.license]];
    
}

- (void)receiveResponse:(HTTPFetcher *)aFetcher
{
    if ([aFetcher class] == [XMLFetcher class]) {
        if ([XMLfetcher.data length] > 0)
        {
            NSLog(@"XML data received: %@", XMLfetcher.results);
        }
    } else {
        if ([JSONfetcher.data length] > 0)
        {
            NSLog(@"JSON data received: %@", JSONfetcher.result);
            NSDictionary * serviceDictionary = [(NSDictionary *)JSONfetcher.result objectForKey:@"service"];
            OSNService * service = [[OSNService alloc] initWithDictionary:serviceDictionary];
            
            for (id dictObj in service.resources) {
                OSNResource * resource = [[OSNResource alloc] initWithDictionary:dictObj];
                NSLog(@"resource: %@", [resource url]);
            }
            [self setViewWithService:service];
        }
   }
}

- (void)viewDidLoad
{
    [super viewDidLoad];

    JSONfetcher = [[JSONFetcher alloc]
                   initWithURLString:[NSString stringWithFormat:@"%@%@",SERVICEURL,JSONMETADATAFILE]
                   receiver:self
                   action:@selector(receiveResponse:)];
    [JSONfetcher start];

}


- (void)viewDidUnload
{
    serviceIDLabel = nil;
    nameLabel = nil;
    authorLabel = nil;
    descriptionLabel = nil;
    emailLabel = nil;
    groupLabel = nil;
    [super viewDidUnload];
    // Release any retained subviews of the main view.
    
    }

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation != UIInterfaceOrientationPortraitUpsideDown);
}

@end
