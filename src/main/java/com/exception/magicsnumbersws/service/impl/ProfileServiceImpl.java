
package com.exception.magicsnumbersws.service.impl;

import com.exception.magicsnumbersws.dao.ProfileDao;
import com.exception.magicsnumbersws.entities.Profile;
import com.exception.magicsnumbersws.exception.SearchAllProfileException;
import com.exception.magicsnumbersws.service.ProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fpimentel
 */
@Service
@Transactional
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileDao profileDao;    

    public ProfileServiceImpl() {
    }

    public ProfileServiceImpl(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public ProfileDao getProfileDao() {
        return profileDao;
    }

    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }
   

    @Override
    public void add(Profile profile) {
       profileDao.add(profile);
    }

    @Override
    public void update(Profile profile) {
        profileDao.update(profile);
    }

    @Override
    public void delete(int profileId) {
        profileDao.delete(profileId);
    }

    @Override
    public Profile findById(int id) {
        return profileDao.findById(id);
    }

    @Override
    public List<Profile> findAll() throws SearchAllProfileException {
        return profileDao.findAll();
    }
       
}
