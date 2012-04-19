//
//  ViewController2.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "XMLFetcher.h"
#import "JSONFetcher.h"
#import "OSN.h"

#define SERVICEURL          @"http://193.145.50.132:8080/OSN/rest/service"
#define XMLOPENDATAFILE     @"/getLastEntry/1324402390199000.xml"
#define JSONOPENDATAFILE    @"/getLastEntry/1324402390199000.json"

@interface ViewController2 : UIViewController {

    IBOutlet UILabel *titleLabel;
    IBOutlet UILabel *idEntryLabel;
    IBOutlet UILabel *sourceIDLabel;
    IBOutlet UILabel *dateLabel;
    IBOutlet UILabel *extraInfoLabel;
    IBOutlet UILabel *unitLabel;
    IBOutlet UILabel *latitudeLabel;
    IBOutlet UILabel *longitudeLabel;
    
    XMLFetcher * XMLfetcher;
    JSONFetcher * JSONfetcher;
    OSNEntry * service;
    
    UIImageView * myImageView;
    
}

@property (nonatomic, strong) XMLFetcher * XMLfetcher;
@property (nonatomic, strong) JSONFetcher * JSONfetcher;
@property (nonatomic, strong) OSNEntry * service;

//-(IBAction)showValue:(id)sender;

@end

