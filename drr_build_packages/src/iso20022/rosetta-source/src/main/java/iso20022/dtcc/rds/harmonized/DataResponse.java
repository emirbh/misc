package iso20022.dtcc.rds.harmonized;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import iso20022.dtcc.rds.harmonized.meta.DataResponseMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="DataResponse", builder=DataResponse.DataResponseBuilderImpl.class, version="${project.version}")
@RuneDataType(value="DataResponse", model="iso20022", builder=DataResponse.DataResponseBuilderImpl.class, version="${project.version}")
public interface DataResponse extends RosettaModelObject {

	DataResponseMeta metaData = new DataResponseMeta();

	/*********************** Getter Methods  ***********************/
	Header getHeader();
	List<? extends GenericAttribute> getSubmissionValidationStatus();
	Core getCore();
	List<? extends iso20022.dtcc.rds.harmonized.Error> getError();
	SubmissionWrapper getOriginalSubmission();

	/*********************** Build Methods  ***********************/
	DataResponse build();
	
	DataResponse.DataResponseBuilder toBuilder();
	
	static DataResponse.DataResponseBuilder builder() {
		return new DataResponse.DataResponseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DataResponse> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DataResponse> getType() {
		return DataResponse.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("header"), processor, Header.class, getHeader());
		processRosetta(path.newSubPath("submissionValidationStatus"), processor, GenericAttribute.class, getSubmissionValidationStatus());
		processRosetta(path.newSubPath("core"), processor, Core.class, getCore());
		processRosetta(path.newSubPath("error"), processor, iso20022.dtcc.rds.harmonized.Error.class, getError());
		processRosetta(path.newSubPath("originalSubmission"), processor, SubmissionWrapper.class, getOriginalSubmission());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DataResponseBuilder extends DataResponse, RosettaModelObjectBuilder {
		Header.HeaderBuilder getOrCreateHeader();
		@Override
		Header.HeaderBuilder getHeader();
		GenericAttribute.GenericAttributeBuilder getOrCreateSubmissionValidationStatus(int index);
		@Override
		List<? extends GenericAttribute.GenericAttributeBuilder> getSubmissionValidationStatus();
		Core.CoreBuilder getOrCreateCore();
		@Override
		Core.CoreBuilder getCore();
		Error.ErrorBuilder getOrCreateError(int index);
		@Override
		List<? extends Error.ErrorBuilder> getError();
		SubmissionWrapper.SubmissionWrapperBuilder getOrCreateOriginalSubmission();
		@Override
		SubmissionWrapper.SubmissionWrapperBuilder getOriginalSubmission();
		DataResponse.DataResponseBuilder setHeader(Header header);
		DataResponse.DataResponseBuilder addSubmissionValidationStatus(GenericAttribute submissionValidationStatus);
		DataResponse.DataResponseBuilder addSubmissionValidationStatus(GenericAttribute submissionValidationStatus, int idx);
		DataResponse.DataResponseBuilder addSubmissionValidationStatus(List<? extends GenericAttribute> submissionValidationStatus);
		DataResponse.DataResponseBuilder setSubmissionValidationStatus(List<? extends GenericAttribute> submissionValidationStatus);
		DataResponse.DataResponseBuilder setCore(Core core);
		DataResponse.DataResponseBuilder addError(iso20022.dtcc.rds.harmonized.Error error);
		DataResponse.DataResponseBuilder addError(iso20022.dtcc.rds.harmonized.Error error, int idx);
		DataResponse.DataResponseBuilder addError(List<? extends iso20022.dtcc.rds.harmonized.Error> error);
		DataResponse.DataResponseBuilder setError(List<? extends iso20022.dtcc.rds.harmonized.Error> error);
		DataResponse.DataResponseBuilder setOriginalSubmission(SubmissionWrapper originalSubmission);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("header"), processor, Header.HeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("submissionValidationStatus"), processor, GenericAttribute.GenericAttributeBuilder.class, getSubmissionValidationStatus());
			processRosetta(path.newSubPath("core"), processor, Core.CoreBuilder.class, getCore());
			processRosetta(path.newSubPath("error"), processor, Error.ErrorBuilder.class, getError());
			processRosetta(path.newSubPath("originalSubmission"), processor, SubmissionWrapper.SubmissionWrapperBuilder.class, getOriginalSubmission());
		}
		

		DataResponse.DataResponseBuilder prune();
	}

	/*********************** Immutable Implementation of DataResponse  ***********************/
	class DataResponseImpl implements DataResponse {
		private final Header header;
		private final List<? extends GenericAttribute> submissionValidationStatus;
		private final Core core;
		private final List<? extends iso20022.dtcc.rds.harmonized.Error> error;
		private final SubmissionWrapper originalSubmission;
		
		protected DataResponseImpl(DataResponse.DataResponseBuilder builder) {
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.submissionValidationStatus = ofNullable(builder.getSubmissionValidationStatus()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.core = ofNullable(builder.getCore()).map(f->f.build()).orElse(null);
			this.error = ofNullable(builder.getError()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.originalSubmission = ofNullable(builder.getOriginalSubmission()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public Header getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("submissionValidationStatus")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("submissionValidationStatus")
		public List<? extends GenericAttribute> getSubmissionValidationStatus() {
			return submissionValidationStatus;
		}
		
		@Override
		@RosettaAttribute("core")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("core")
		public Core getCore() {
			return core;
		}
		
		@Override
		@RosettaAttribute("error")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("error")
		public List<? extends iso20022.dtcc.rds.harmonized.Error> getError() {
			return error;
		}
		
		@Override
		@RosettaAttribute("originalSubmission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSubmission")
		public SubmissionWrapper getOriginalSubmission() {
			return originalSubmission;
		}
		
		@Override
		public DataResponse build() {
			return this;
		}
		
		@Override
		public DataResponse.DataResponseBuilder toBuilder() {
			DataResponse.DataResponseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DataResponse.DataResponseBuilder builder) {
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getSubmissionValidationStatus()).ifPresent(builder::setSubmissionValidationStatus);
			ofNullable(getCore()).ifPresent(builder::setCore);
			ofNullable(getError()).ifPresent(builder::setError);
			ofNullable(getOriginalSubmission()).ifPresent(builder::setOriginalSubmission);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataResponse _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(submissionValidationStatus, _that.getSubmissionValidationStatus())) return false;
			if (!Objects.equals(core, _that.getCore())) return false;
			if (!ListEquals.listEquals(error, _that.getError())) return false;
			if (!Objects.equals(originalSubmission, _that.getOriginalSubmission())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (submissionValidationStatus != null ? submissionValidationStatus.hashCode() : 0);
			_result = 31 * _result + (core != null ? core.hashCode() : 0);
			_result = 31 * _result + (error != null ? error.hashCode() : 0);
			_result = 31 * _result + (originalSubmission != null ? originalSubmission.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataResponse {" +
				"header=" + this.header + ", " +
				"submissionValidationStatus=" + this.submissionValidationStatus + ", " +
				"core=" + this.core + ", " +
				"error=" + this.error + ", " +
				"originalSubmission=" + this.originalSubmission +
			'}';
		}
	}

	/*********************** Builder Implementation of DataResponse  ***********************/
	class DataResponseBuilderImpl implements DataResponse.DataResponseBuilder {
	
		protected Header.HeaderBuilder header;
		protected List<GenericAttribute.GenericAttributeBuilder> submissionValidationStatus = new ArrayList<>();
		protected Core.CoreBuilder core;
		protected List<Error.ErrorBuilder> error = new ArrayList<>();
		protected SubmissionWrapper.SubmissionWrapperBuilder originalSubmission;
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("header")
		public Header.HeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public Header.HeaderBuilder getOrCreateHeader() {
			Header.HeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = Header.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("submissionValidationStatus")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("submissionValidationStatus")
		public List<? extends GenericAttribute.GenericAttributeBuilder> getSubmissionValidationStatus() {
			return submissionValidationStatus;
		}
		
		@Override
		public GenericAttribute.GenericAttributeBuilder getOrCreateSubmissionValidationStatus(int index) {
			if (submissionValidationStatus==null) {
				this.submissionValidationStatus = new ArrayList<>();
			}
			return getIndex(submissionValidationStatus, index, () -> {
						GenericAttribute.GenericAttributeBuilder newSubmissionValidationStatus = GenericAttribute.builder();
						return newSubmissionValidationStatus;
					});
		}
		
		@Override
		@RosettaAttribute("core")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("core")
		public Core.CoreBuilder getCore() {
			return core;
		}
		
		@Override
		public Core.CoreBuilder getOrCreateCore() {
			Core.CoreBuilder result;
			if (core!=null) {
				result = core;
			}
			else {
				result = core = Core.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("error")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("error")
		public List<? extends Error.ErrorBuilder> getError() {
			return error;
		}
		
		@Override
		public Error.ErrorBuilder getOrCreateError(int index) {
			if (error==null) {
				this.error = new ArrayList<>();
			}
			return getIndex(error, index, () -> {
						Error.ErrorBuilder newError = iso20022.dtcc.rds.harmonized.Error.builder();
						return newError;
					});
		}
		
		@Override
		@RosettaAttribute("originalSubmission")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalSubmission")
		public SubmissionWrapper.SubmissionWrapperBuilder getOriginalSubmission() {
			return originalSubmission;
		}
		
		@Override
		public SubmissionWrapper.SubmissionWrapperBuilder getOrCreateOriginalSubmission() {
			SubmissionWrapper.SubmissionWrapperBuilder result;
			if (originalSubmission!=null) {
				result = originalSubmission;
			}
			else {
				result = originalSubmission = SubmissionWrapper.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("header")
		@Override
		public DataResponse.DataResponseBuilder setHeader(Header _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("submissionValidationStatus")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("submissionValidationStatus")
		@Override
		public DataResponse.DataResponseBuilder addSubmissionValidationStatus(GenericAttribute _submissionValidationStatus) {
			if (_submissionValidationStatus != null) {
				this.submissionValidationStatus.add(_submissionValidationStatus.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataResponse.DataResponseBuilder addSubmissionValidationStatus(GenericAttribute _submissionValidationStatus, int idx) {
			getIndex(this.submissionValidationStatus, idx, () -> _submissionValidationStatus.toBuilder());
			return this;
		}
		
		@Override
		public DataResponse.DataResponseBuilder addSubmissionValidationStatus(List<? extends GenericAttribute> submissionValidationStatuss) {
			if (submissionValidationStatuss != null) {
				for (final GenericAttribute toAdd : submissionValidationStatuss) {
					this.submissionValidationStatus.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("submissionValidationStatus")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("submissionValidationStatus")
		@Override
		public DataResponse.DataResponseBuilder setSubmissionValidationStatus(List<? extends GenericAttribute> submissionValidationStatuss) {
			if (submissionValidationStatuss == null) {
				this.submissionValidationStatus = new ArrayList<>();
			} else {
				this.submissionValidationStatus = submissionValidationStatuss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("core")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("core")
		@Override
		public DataResponse.DataResponseBuilder setCore(Core _core) {
			this.core = _core == null ? null : _core.toBuilder();
			return this;
		}
		
		@RosettaAttribute("error")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("error")
		@Override
		public DataResponse.DataResponseBuilder addError(iso20022.dtcc.rds.harmonized.Error _error) {
			if (_error != null) {
				this.error.add(_error.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataResponse.DataResponseBuilder addError(iso20022.dtcc.rds.harmonized.Error _error, int idx) {
			getIndex(this.error, idx, () -> _error.toBuilder());
			return this;
		}
		
		@Override
		public DataResponse.DataResponseBuilder addError(List<? extends iso20022.dtcc.rds.harmonized.Error> errors) {
			if (errors != null) {
				for (final iso20022.dtcc.rds.harmonized.Error toAdd : errors) {
					this.error.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("error")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("error")
		@Override
		public DataResponse.DataResponseBuilder setError(List<? extends iso20022.dtcc.rds.harmonized.Error> errors) {
			if (errors == null) {
				this.error = new ArrayList<>();
			} else {
				this.error = errors.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("originalSubmission")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalSubmission")
		@Override
		public DataResponse.DataResponseBuilder setOriginalSubmission(SubmissionWrapper _originalSubmission) {
			this.originalSubmission = _originalSubmission == null ? null : _originalSubmission.toBuilder();
			return this;
		}
		
		@Override
		public DataResponse build() {
			return new DataResponse.DataResponseImpl(this);
		}
		
		@Override
		public DataResponse.DataResponseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataResponse.DataResponseBuilder prune() {
			if (header!=null && !header.prune().hasData()) header = null;
			submissionValidationStatus = submissionValidationStatus.stream().filter(b->b!=null).<GenericAttribute.GenericAttributeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (core!=null && !core.prune().hasData()) core = null;
			error = error.stream().filter(b->b!=null).<Error.ErrorBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (originalSubmission!=null && !originalSubmission.prune().hasData()) originalSubmission = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getSubmissionValidationStatus()!=null && getSubmissionValidationStatus().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCore()!=null && getCore().hasData()) return true;
			if (getError()!=null && getError().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOriginalSubmission()!=null && getOriginalSubmission().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataResponse.DataResponseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DataResponse.DataResponseBuilder o = (DataResponse.DataResponseBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getSubmissionValidationStatus(), o.getSubmissionValidationStatus(), this::getOrCreateSubmissionValidationStatus);
			merger.mergeRosetta(getCore(), o.getCore(), this::setCore);
			merger.mergeRosetta(getError(), o.getError(), this::getOrCreateError);
			merger.mergeRosetta(getOriginalSubmission(), o.getOriginalSubmission(), this::setOriginalSubmission);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DataResponse _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(submissionValidationStatus, _that.getSubmissionValidationStatus())) return false;
			if (!Objects.equals(core, _that.getCore())) return false;
			if (!ListEquals.listEquals(error, _that.getError())) return false;
			if (!Objects.equals(originalSubmission, _that.getOriginalSubmission())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (submissionValidationStatus != null ? submissionValidationStatus.hashCode() : 0);
			_result = 31 * _result + (core != null ? core.hashCode() : 0);
			_result = 31 * _result + (error != null ? error.hashCode() : 0);
			_result = 31 * _result + (originalSubmission != null ? originalSubmission.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataResponseBuilder {" +
				"header=" + this.header + ", " +
				"submissionValidationStatus=" + this.submissionValidationStatus + ", " +
				"core=" + this.core + ", " +
				"error=" + this.error + ", " +
				"originalSubmission=" + this.originalSubmission +
			'}';
		}
	}
}
