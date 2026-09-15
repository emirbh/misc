package iso20022.dtcc.rds.harmonized;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.dtcc.rds.harmonized.meta.ErrorMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Error", builder=Error.ErrorBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Error", model="iso20022", builder=Error.ErrorBuilderImpl.class, version="${project.version}")
public interface Error extends RosettaModelObject {

	ErrorMeta metaData = new ErrorMeta();

	/*********************** Getter Methods  ***********************/
	String getErrorCode();
	String getErrorReason();
	String getErrorJurisdiction();
	String getErrorFor();

	/*********************** Build Methods  ***********************/
	Error build();
	
	Error.ErrorBuilder toBuilder();
	
	static Error.ErrorBuilder builder() {
		return new Error.ErrorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Error> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Error> getType() {
		return Error.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("errorCode"), String.class, getErrorCode(), this);
		processor.processBasic(path.newSubPath("errorReason"), String.class, getErrorReason(), this);
		processor.processBasic(path.newSubPath("errorJurisdiction"), String.class, getErrorJurisdiction(), this);
		processor.processBasic(path.newSubPath("errorFor"), String.class, getErrorFor(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ErrorBuilder extends Error, RosettaModelObjectBuilder {
		Error.ErrorBuilder setErrorCode(String errorCode);
		Error.ErrorBuilder setErrorReason(String errorReason);
		Error.ErrorBuilder setErrorJurisdiction(String errorJurisdiction);
		Error.ErrorBuilder setErrorFor(String errorFor);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("errorCode"), String.class, getErrorCode(), this);
			processor.processBasic(path.newSubPath("errorReason"), String.class, getErrorReason(), this);
			processor.processBasic(path.newSubPath("errorJurisdiction"), String.class, getErrorJurisdiction(), this);
			processor.processBasic(path.newSubPath("errorFor"), String.class, getErrorFor(), this);
		}
		

		Error.ErrorBuilder prune();
	}

	/*********************** Immutable Implementation of Error  ***********************/
	class ErrorImpl implements Error {
		private final String errorCode;
		private final String errorReason;
		private final String errorJurisdiction;
		private final String errorFor;
		
		protected ErrorImpl(Error.ErrorBuilder builder) {
			this.errorCode = builder.getErrorCode();
			this.errorReason = builder.getErrorReason();
			this.errorJurisdiction = builder.getErrorJurisdiction();
			this.errorFor = builder.getErrorFor();
		}
		
		@Override
		@RosettaAttribute("errorCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorCode")
		public String getErrorCode() {
			return errorCode;
		}
		
		@Override
		@RosettaAttribute("errorReason")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorReason")
		public String getErrorReason() {
			return errorReason;
		}
		
		@Override
		@RosettaAttribute("errorJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorJurisdiction")
		public String getErrorJurisdiction() {
			return errorJurisdiction;
		}
		
		@Override
		@RosettaAttribute("errorFor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorFor")
		public String getErrorFor() {
			return errorFor;
		}
		
		@Override
		public Error build() {
			return this;
		}
		
		@Override
		public Error.ErrorBuilder toBuilder() {
			Error.ErrorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Error.ErrorBuilder builder) {
			ofNullable(getErrorCode()).ifPresent(builder::setErrorCode);
			ofNullable(getErrorReason()).ifPresent(builder::setErrorReason);
			ofNullable(getErrorJurisdiction()).ifPresent(builder::setErrorJurisdiction);
			ofNullable(getErrorFor()).ifPresent(builder::setErrorFor);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Error _that = getType().cast(o);
		
			if (!Objects.equals(errorCode, _that.getErrorCode())) return false;
			if (!Objects.equals(errorReason, _that.getErrorReason())) return false;
			if (!Objects.equals(errorJurisdiction, _that.getErrorJurisdiction())) return false;
			if (!Objects.equals(errorFor, _that.getErrorFor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (errorCode != null ? errorCode.hashCode() : 0);
			_result = 31 * _result + (errorReason != null ? errorReason.hashCode() : 0);
			_result = 31 * _result + (errorJurisdiction != null ? errorJurisdiction.hashCode() : 0);
			_result = 31 * _result + (errorFor != null ? errorFor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Error {" +
				"errorCode=" + this.errorCode + ", " +
				"errorReason=" + this.errorReason + ", " +
				"errorJurisdiction=" + this.errorJurisdiction + ", " +
				"errorFor=" + this.errorFor +
			'}';
		}
	}

	/*********************** Builder Implementation of Error  ***********************/
	class ErrorBuilderImpl implements Error.ErrorBuilder {
	
		protected String errorCode;
		protected String errorReason;
		protected String errorJurisdiction;
		protected String errorFor;
		
		@Override
		@RosettaAttribute("errorCode")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorCode")
		public String getErrorCode() {
			return errorCode;
		}
		
		@Override
		@RosettaAttribute("errorReason")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorReason")
		public String getErrorReason() {
			return errorReason;
		}
		
		@Override
		@RosettaAttribute("errorJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorJurisdiction")
		public String getErrorJurisdiction() {
			return errorJurisdiction;
		}
		
		@Override
		@RosettaAttribute("errorFor")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("errorFor")
		public String getErrorFor() {
			return errorFor;
		}
		
		@RosettaAttribute("errorCode")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("errorCode")
		@Override
		public Error.ErrorBuilder setErrorCode(String _errorCode) {
			this.errorCode = _errorCode == null ? null : _errorCode;
			return this;
		}
		
		@RosettaAttribute("errorReason")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("errorReason")
		@Override
		public Error.ErrorBuilder setErrorReason(String _errorReason) {
			this.errorReason = _errorReason == null ? null : _errorReason;
			return this;
		}
		
		@RosettaAttribute("errorJurisdiction")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("errorJurisdiction")
		@Override
		public Error.ErrorBuilder setErrorJurisdiction(String _errorJurisdiction) {
			this.errorJurisdiction = _errorJurisdiction == null ? null : _errorJurisdiction;
			return this;
		}
		
		@RosettaAttribute("errorFor")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("errorFor")
		@Override
		public Error.ErrorBuilder setErrorFor(String _errorFor) {
			this.errorFor = _errorFor == null ? null : _errorFor;
			return this;
		}
		
		@Override
		public Error build() {
			return new Error.ErrorImpl(this);
		}
		
		@Override
		public Error.ErrorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Error.ErrorBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getErrorCode()!=null) return true;
			if (getErrorReason()!=null) return true;
			if (getErrorJurisdiction()!=null) return true;
			if (getErrorFor()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Error.ErrorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Error.ErrorBuilder o = (Error.ErrorBuilder) other;
			
			
			merger.mergeBasic(getErrorCode(), o.getErrorCode(), this::setErrorCode);
			merger.mergeBasic(getErrorReason(), o.getErrorReason(), this::setErrorReason);
			merger.mergeBasic(getErrorJurisdiction(), o.getErrorJurisdiction(), this::setErrorJurisdiction);
			merger.mergeBasic(getErrorFor(), o.getErrorFor(), this::setErrorFor);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Error _that = getType().cast(o);
		
			if (!Objects.equals(errorCode, _that.getErrorCode())) return false;
			if (!Objects.equals(errorReason, _that.getErrorReason())) return false;
			if (!Objects.equals(errorJurisdiction, _that.getErrorJurisdiction())) return false;
			if (!Objects.equals(errorFor, _that.getErrorFor())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (errorCode != null ? errorCode.hashCode() : 0);
			_result = 31 * _result + (errorReason != null ? errorReason.hashCode() : 0);
			_result = 31 * _result + (errorJurisdiction != null ? errorJurisdiction.hashCode() : 0);
			_result = 31 * _result + (errorFor != null ? errorFor.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ErrorBuilder {" +
				"errorCode=" + this.errorCode + ", " +
				"errorReason=" + this.errorReason + ", " +
				"errorJurisdiction=" + this.errorJurisdiction + ", " +
				"errorFor=" + this.errorFor +
			'}';
		}
	}
}
