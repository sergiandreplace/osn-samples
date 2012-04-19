//
//  ViewController.h
//  UseOSNService
//
//  Created by Luis Lopez on 22/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "HTTPFetcher.h"
#import "XMLFetcher.h"
#import "JSONFetcher.h"

#define SERVICEURL          @"http://193.145.50.132:8080/OSN/rest/service"
#define XMLMETADATAFILE     @"/getService/1324402390199000.xml"
#define JSONMETADATAFILE    @"/getService/1324402390199000.json"

@interface ViewController : UIViewController{
    
    IBOutlet UILabel *titleLabel;
    IBOutlet UILabel *serviceIDLabel;
    IBOutlet UILabel *nameLabel;
    IBOutlet UILabel *authorLabel;
    IBOutlet UILabel *descriptionLabel;
    IBOutlet UILabel *emailLabel;
    IBOutlet UILabel *groupLabel;
    IBOutlet UILabel *latitudeLabel;
    IBOutlet UILabel *longitudeLabel;
    IBOutlet UILabel *twitterLabel;
    IBOutlet UILabel *updateLabel;
    IBOutlet UILabel *urlLabel;
    IBOutlet UILabel *tagLabel;
    
    XMLFetcher * XMLfetcher;
    JSONFetcher * JSONfetcher;
    
}

@property (nonatomic, strong) XMLFetcher * XMLfetcher;
@property (nonatomic, strong) JSONFetcher * JSONfetcher;

@end
