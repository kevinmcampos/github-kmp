//
//  MemberList.swift
//  githubkmp
//
//  Created by Kevin Campos on 01/06/2020.
//  Copyright © 2020 Kevin. All rights reserved.
//

import Foundation
import shared

class MemberList {
    
    var members: [Member] = []
    
    func updateMembers(_ newMembers: [Member]) {
        members.removeAll()
        members.append(contentsOf: newMembers)
    }
}
