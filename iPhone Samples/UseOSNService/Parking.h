//
//  Parking.h
//  UseOSNService
//
//  Created by Luis Lopez on 28/03/12.
//  Copyright (c) 2012 Tempos 21. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface Parking : NSObject {
    
    NSString * parkingID;
    NSString * longitude;
    NSString * latitude;
    NSString * adress;
    NSString * price;
    
}

@property(strong, nonatomic) NSString * parkingID;
@property(strong, nonatomic) NSString * longitude;
@property(strong, nonatomic) NSString * latitude;
@property(strong, nonatomic) NSString * adress;
@property(strong, nonatomic) NSString * price;

-(Parking *)initWithDiccionary:(NSDictionary *)dict;

@end
