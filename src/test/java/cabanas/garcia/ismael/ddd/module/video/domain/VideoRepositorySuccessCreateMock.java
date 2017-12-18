package cabanas.garcia.ismael.ddd.module.video.domain;

import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public final class VideoRepositorySuccessCreateMock implements VideoRepository {
    private VideoRepository videoRepositoryMock;

    public VideoRepositorySuccessCreateMock(Video video) {
        videoRepositoryMock = mock(VideoRepository.class);
        doNothing().when(videoRepositoryMock).save(video);
    }

    @Override
    public void save(Video video) {
        videoRepositoryMock.save(video);
    }

    @Override
    public List<Video> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Video> findLastPublished() {
        throw new UnsupportedOperationException();
    }

    public void shouldSave(Video video) {
        verify(videoRepositoryMock, Mockito.times(1)).save(video);
    }
}
