package cabanas.garcia.ismael.ddd.module.video.domain;

import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VideoRepositorySuccessCreateStub implements VideoRepository {
    private VideoRepository videoRepositoryMock;

    public VideoRepositorySuccessCreateStub(Video video) {
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

    public void shouldSave(Video video) {
        verify(videoRepositoryMock, Mockito.times(1)).save(video);
    }
}
