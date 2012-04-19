//
//  OSNService.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OSNService : NSObject {
    
    NSString * idService;
    NSString * group;
    NSString * description;
    NSString * longitude;
    NSString * latitude;
    NSString * url;
    NSString * license;
    NSString * email;
    NSString * tag;
    NSDictionary * resources;
    NSString * author;
    NSString * name;
    NSString * twitter_account;
    NSString * update_period;
    NSDictionary * extras;
    
}

@property(strong, nonatomic) NSString * idService;
@property(strong, nonatomic) NSString * group;
@property(strong, nonatomic) NSString * description;
@property(strong, nonatomic) NSString * longitude;
@property(strong, nonatomic) NSString * latitude;
@property(strong, nonatomic) NSString * url;
@property(strong, nonatomic) NSString * license;
@property(strong, nonatomic) NSString * email;
@property(strong, nonatomic) NSString * tag;
@property(strong, nonatomic) NSDictionary * resources;
@property(strong, nonatomic) NSString * author;
@property(strong, nonatomic) NSString * name;
@property(strong, nonatomic) NSString * twitter_account;
@property(strong, nonatomic) NSString * update_period;
@property(strong, nonatomic) NSDictionary * extras;

-(OSNService *)initWithDictionary:(NSDictionary *)dict;

@end
