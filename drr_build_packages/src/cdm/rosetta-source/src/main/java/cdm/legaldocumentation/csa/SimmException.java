package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.SimmExceptionMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the SIMM exception to the regulatory regime clause.
 * @version 6.23.0
 *
 * Body ISDA
 * Corpus Annex CSA_IM_2016 ISDA 2016 Credit Support Annex for Initial Margin  
 * paragraph "13 General Principles" * name "Regime: SIMM Exception."
 *
 * Provision 
 *
 */
@RosettaDataType(value="SimmException", builder=SimmException.SimmExceptionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="SimmException", model="cdm", builder=SimmException.SimmExceptionBuilderImpl.class, version="6.23.0")
public interface SimmException extends RosettaModelObject {

	SimmExceptionMeta metaData = new SimmExceptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.
	 */
	ExceptionEnum getStandardisedException();
	/**
	 * The Standard Initial Margin model exception approach applicable when specified by the party according to one of the enumerated values.
	 */
	SimmExceptionApplicableEnum getSimmExceptionApplicable();
	/**
	 * The Standard Initial Margin Model exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();

	/*********************** Build Methods  ***********************/
	SimmException build();
	
	SimmException.SimmExceptionBuilder toBuilder();
	
	static SimmException.SimmExceptionBuilder builder() {
		return new SimmException.SimmExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SimmException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SimmException> getType() {
		return SimmException.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
		processor.processBasic(path.newSubPath("simmExceptionApplicable"), SimmExceptionApplicableEnum.class, getSimmExceptionApplicable(), this);
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface SimmExceptionBuilder extends SimmException, RosettaModelObjectBuilder {
		SimmException.SimmExceptionBuilder setStandardisedException(ExceptionEnum standardisedException);
		SimmException.SimmExceptionBuilder setSimmExceptionApplicable(SimmExceptionApplicableEnum simmExceptionApplicable);
		SimmException.SimmExceptionBuilder setAsSpecified(String asSpecified);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
			processor.processBasic(path.newSubPath("simmExceptionApplicable"), SimmExceptionApplicableEnum.class, getSimmExceptionApplicable(), this);
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		}
		

		SimmException.SimmExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of SimmException  ***********************/
	class SimmExceptionImpl implements SimmException {
		private final ExceptionEnum standardisedException;
		private final SimmExceptionApplicableEnum simmExceptionApplicable;
		private final String asSpecified;
		
		protected SimmExceptionImpl(SimmException.SimmExceptionBuilder builder) {
			this.standardisedException = builder.getStandardisedException();
			this.simmExceptionApplicable = builder.getSimmExceptionApplicable();
			this.asSpecified = builder.getAsSpecified();
		}
		
		@Override
		@RosettaAttribute("standardisedException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardisedException")
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
		@Override
		@RosettaAttribute("simmExceptionApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmExceptionApplicable")
		public SimmExceptionApplicableEnum getSimmExceptionApplicable() {
			return simmExceptionApplicable;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public SimmException build() {
			return this;
		}
		
		@Override
		public SimmException.SimmExceptionBuilder toBuilder() {
			SimmException.SimmExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SimmException.SimmExceptionBuilder builder) {
			ofNullable(getStandardisedException()).ifPresent(builder::setStandardisedException);
			ofNullable(getSimmExceptionApplicable()).ifPresent(builder::setSimmExceptionApplicable);
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmException _that = getType().cast(o);
		
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			if (!Objects.equals(simmExceptionApplicable, _that.getSimmExceptionApplicable())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (simmExceptionApplicable != null ? simmExceptionApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmException {" +
				"standardisedException=" + this.standardisedException + ", " +
				"simmExceptionApplicable=" + this.simmExceptionApplicable + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}

	/*********************** Builder Implementation of SimmException  ***********************/
	class SimmExceptionBuilderImpl implements SimmException.SimmExceptionBuilder {
	
		protected ExceptionEnum standardisedException;
		protected SimmExceptionApplicableEnum simmExceptionApplicable;
		protected String asSpecified;
		
		@Override
		@RosettaAttribute("standardisedException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardisedException")
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
		}
		
		@Override
		@RosettaAttribute("simmExceptionApplicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("simmExceptionApplicable")
		public SimmExceptionApplicableEnum getSimmExceptionApplicable() {
			return simmExceptionApplicable;
		}
		
		@Override
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@RosettaAttribute("standardisedException")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("standardisedException")
		@Override
		public SimmException.SimmExceptionBuilder setStandardisedException(ExceptionEnum _standardisedException) {
			this.standardisedException = _standardisedException == null ? null : _standardisedException;
			return this;
		}
		
		@RosettaAttribute("simmExceptionApplicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("simmExceptionApplicable")
		@Override
		public SimmException.SimmExceptionBuilder setSimmExceptionApplicable(SimmExceptionApplicableEnum _simmExceptionApplicable) {
			this.simmExceptionApplicable = _simmExceptionApplicable == null ? null : _simmExceptionApplicable;
			return this;
		}
		
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asSpecified")
		@Override
		public SimmException.SimmExceptionBuilder setAsSpecified(String _asSpecified) {
			this.asSpecified = _asSpecified == null ? null : _asSpecified;
			return this;
		}
		
		@Override
		public SimmException build() {
			return new SimmException.SimmExceptionImpl(this);
		}
		
		@Override
		public SimmException.SimmExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmException.SimmExceptionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardisedException()!=null) return true;
			if (getSimmExceptionApplicable()!=null) return true;
			if (getAsSpecified()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SimmException.SimmExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SimmException.SimmExceptionBuilder o = (SimmException.SimmExceptionBuilder) other;
			
			
			merger.mergeBasic(getStandardisedException(), o.getStandardisedException(), this::setStandardisedException);
			merger.mergeBasic(getSimmExceptionApplicable(), o.getSimmExceptionApplicable(), this::setSimmExceptionApplicable);
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SimmException _that = getType().cast(o);
		
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			if (!Objects.equals(simmExceptionApplicable, _that.getSimmExceptionApplicable())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (simmExceptionApplicable != null ? simmExceptionApplicable.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SimmExceptionBuilder {" +
				"standardisedException=" + this.standardisedException + ", " +
				"simmExceptionApplicable=" + this.simmExceptionApplicable + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}
}
