//
//  OSNResource.h
//  UseOSNService
//
//  Created by Luis Lopez on 26/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface OSNResource : NSObject {

    NSString * url;
    NSString * format;
    NSString * description;
    
}

@property(nonatomic, strong) NSString * url;
@property(nonatomic, strong) NSString * format;
@property(nonatomic, strong) NSString * description;

-(OSNResource *)initWithDictionary:(NSDictionary *) dict;

@end
