package cic.challenge.com.repository;

import cic.challenge.com.entity.FilmLocation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmLocationRepository extends PagingAndSortingRepository<FilmLocation, Long> {
}
