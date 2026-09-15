package iso20022.dtcc.rds.harmonized;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.dtcc.rds.harmonized.meta.DocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Document", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Document", model="iso20022", builder=Document.DocumentBuilderImpl.class, version="${project.version}")
public interface Document extends RosettaModelObject {

	DocumentMeta metaData = new DocumentMeta();

	/*********************** Getter Methods  ***********************/
	DataSubmission getSubmission();
	DataResponse getResponse();

	/*********************** Build Methods  ***********************/
	Document build();
	
	Document.DocumentBuilder toBuilder();
	
	static Document.DocumentBuilder builder() {
		return new Document.DocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Document> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Document> getType() {
		return Document.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("submission"), processor, DataSubmission.class, getSubmission());
		processRosetta(path.newSubPath("response"), processor, DataResponse.class, getResponse());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		DataSubmission.DataSubmissionBuilder getOrCreateSubmission();
		@Override
		DataSubmission.DataSubmissionBuilder getSubmission();
		DataResponse.DataResponseBuilder getOrCreateResponse();
		@Override
		DataResponse.DataResponseBuilder getResponse();
		Document.DocumentBuilder setSubmission(DataSubmission submission);
		Document.DocumentBuilder setResponse(DataResponse response);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("submission"), processor, DataSubmission.DataSubmissionBuilder.class, getSubmission());
			processRosetta(path.newSubPath("response"), processor, DataResponse.DataResponseBuilder.class, getResponse());
		}
		

		Document.DocumentBuilder prune();
	}

	/*********************** Immutable Implementation of Document  ***********************/
	class DocumentImpl implements Document {
		private final DataSubmission submission;
		private final DataResponse response;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.submission = ofNullable(builder.getSubmission()).map(f->f.build()).orElse(null);
			this.response = ofNullable(builder.getResponse()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("submission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submission")
		public DataSubmission getSubmission() {
			return submission;
		}
		
		@Override
		@RosettaAttribute("response")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("response")
		public DataResponse getResponse() {
			return response;
		}
		
		@Override
		public Document build() {
			return this;
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			Document.DocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Document.DocumentBuilder builder) {
			ofNullable(getSubmission()).ifPresent(builder::setSubmission);
			ofNullable(getResponse()).ifPresent(builder::setResponse);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(submission, _that.getSubmission())) return false;
			if (!Objects.equals(response, _that.getResponse())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (submission != null ? submission.hashCode() : 0);
			_result = 31 * _result + (response != null ? response.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"submission=" + this.submission + ", " +
				"response=" + this.response +
			'}';
		}
	}

	/*********************** Builder Implementation of Document  ***********************/
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected DataSubmission.DataSubmissionBuilder submission;
		protected DataResponse.DataResponseBuilder response;
		
		@Override
		@RosettaAttribute("submission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("submission")
		public DataSubmission.DataSubmissionBuilder getSubmission() {
			return submission;
		}
		
		@Override
		public DataSubmission.DataSubmissionBuilder getOrCreateSubmission() {
			DataSubmission.DataSubmissionBuilder result;
			if (submission!=null) {
				result = submission;
			}
			else {
				result = submission = DataSubmission.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("response")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("response")
		public DataResponse.DataResponseBuilder getResponse() {
			return response;
		}
		
		@Override
		public DataResponse.DataResponseBuilder getOrCreateResponse() {
			DataResponse.DataResponseBuilder result;
			if (response!=null) {
				result = response;
			}
			else {
				result = response = DataResponse.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("submission")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("submission")
		@Override
		public Document.DocumentBuilder setSubmission(DataSubmission _submission) {
			this.submission = _submission == null ? null : _submission.toBuilder();
			return this;
		}
		
		@RosettaAttribute("response")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("response")
		@Override
		public Document.DocumentBuilder setResponse(DataResponse _response) {
			this.response = _response == null ? null : _response.toBuilder();
			return this;
		}
		
		@Override
		public Document build() {
			return new Document.DocumentImpl(this);
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder prune() {
			if (submission!=null && !submission.prune().hasData()) submission = null;
			if (response!=null && !response.prune().hasData()) response = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSubmission()!=null && getSubmission().hasData()) return true;
			if (getResponse()!=null && getResponse().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			merger.mergeRosetta(getSubmission(), o.getSubmission(), this::setSubmission);
			merger.mergeRosetta(getResponse(), o.getResponse(), this::setResponse);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(submission, _that.getSubmission())) return false;
			if (!Objects.equals(response, _that.getResponse())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (submission != null ? submission.hashCode() : 0);
			_result = 31 * _result + (response != null ? response.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"submission=" + this.submission + ", " +
				"response=" + this.response +
			'}';
		}
	}
}
