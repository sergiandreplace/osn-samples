//
//  ViewController2.m
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import "ViewController2.h"
#import "ValueViewController.h"
#import "SBJsonParser.h"


@interface ViewController2 ()

@end

@implementation ViewController2

@synthesize XMLfetcher, JSONfetcher, service;

-(IBAction)showValue:(id)sender {
    
    ValueViewController *valueController = [self.storyboard instantiateViewControllerWithIdentifier:@"ValueViewController"];
    valueController.text = service.value;
    [self.navigationController pushViewController:valueController animated:YES];
    
}

-(void)setViewWithService:(OSNEntry *)serv{
    
    [titleLabel setText:@"OSN Open Data service"];
    
    [idEntryLabel setText:[NSString stringWithFormat:@"%@%@",idEntryLabel.text, serv.idEntry]];
    [sourceIDLabel setText:[NSString stringWithFormat:@"%@%@",sourceIDLabel.text, serv.sourceID]];
    [dateLabel setText:[NSString stringWithFormat:@"%@%@",dateLabel.text, serv.date]];
    [extraInfoLabel setText:[NSString stringWithFormat:@"%@%@",extraInfoLabel.text, serv.extraInfo]];
    [unitLabel setText:[NSString stringWithFormat:@"%@%@",unitLabel.text, serv.unit]];
    [latitudeLabel setText:[NSString stringWithFormat:@"%@%@",latitudeLabel.text, serv.latitude]];
    [longitudeLabel setText:[NSString stringWithFormat:@"%@%@",longitudeLabel.text, serv.longitude]];
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
            NSDictionary * serviceDictionary = [(NSDictionary *)JSONfetcher.result objectForKey:@"entry"];
            service = [[OSNEntry alloc] initWithDictionary:serviceDictionary];
            [self setViewWithService:service];
        }
    }
}

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (void)viewDidLoad
{
    [super viewDidLoad];
    
	JSONfetcher = [[JSONFetcher alloc]
                   initWithURLString:[NSString stringWithFormat:@"%@%@",SERVICEURL,JSONOPENDATAFILE]
                   receiver:self
                   action:@selector(receiveResponse:)];
    [JSONfetcher start];
}

- (void)viewDidUnload
{
    [super viewDidUnload];
    // Release any retained subviews of the main view.
}

- (BOOL)shouldAutorotateToInterfaceOrientation:(UIInterfaceOrientation)interfaceOrientation
{
    return (interfaceOrientation == UIInterfaceOrientationPortrait);
}

@end
