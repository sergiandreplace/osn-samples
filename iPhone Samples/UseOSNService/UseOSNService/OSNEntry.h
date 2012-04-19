//
//  OSNEntry.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OSNEntry : NSObject {
    
    NSNumber * idEntry;
    NSString * sourceID;
    NSString * date;
    NSString * value;
    NSString * unit;
    NSString * extraInfo;
    NSString * latitude;
    NSString * longitude;
}

@property(nonatomic, strong) NSNumber * idEntry;
@property(nonatomic, strong) NSString * sourceID;
@property(nonatomic, strong) NSString * date;
@property(nonatomic, strong) NSString * value;
@property(nonatomic, strong) NSString * unit;
@property(nonatomic, strong) NSString * extraInfo;
@property(nonatomic, strong) NSString * latitude;
@property(nonatomic, strong) NSString * longitude;

-(OSNEntry *)initWithDictionary:(NSDictionary *)dict;

@end
