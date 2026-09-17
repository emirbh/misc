package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.RetrospectiveEffectMeta;
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
 * A class to specify the retrospective effect exception to the regulatory regime clause of Initial Margin documents as either a normalized value specified as part of an enumeration or a customized value specified of type string.
 * @version 6.23.0
 */
@RosettaDataType(value="RetrospectiveEffect", builder=RetrospectiveEffect.RetrospectiveEffectBuilderImpl.class, version="6.23.0")
@RuneDataType(value="RetrospectiveEffect", model="cdm", builder=RetrospectiveEffect.RetrospectiveEffectBuilderImpl.class, version="6.23.0")
public interface RetrospectiveEffect extends RosettaModelObject {

	RetrospectiveEffectMeta metaData = new RetrospectiveEffectMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The Standard Initial Margin Model exception when specified by the party according to one of the enumerated values.
	 */
	ExceptionEnum getStandardisedException();
	/**
	 * The Standard Initial Margin Model exception when specified as a customized approach by the party.
	 */
	String getAsSpecified();

	/*********************** Build Methods  ***********************/
	RetrospectiveEffect build();
	
	RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder();
	
	static RetrospectiveEffect.RetrospectiveEffectBuilder builder() {
		return new RetrospectiveEffect.RetrospectiveEffectBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RetrospectiveEffect> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RetrospectiveEffect> getType() {
		return RetrospectiveEffect.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
		processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RetrospectiveEffectBuilder extends RetrospectiveEffect, RosettaModelObjectBuilder {
		RetrospectiveEffect.RetrospectiveEffectBuilder setStandardisedException(ExceptionEnum standardisedException);
		RetrospectiveEffect.RetrospectiveEffectBuilder setAsSpecified(String asSpecified);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("standardisedException"), ExceptionEnum.class, getStandardisedException(), this);
			processor.processBasic(path.newSubPath("asSpecified"), String.class, getAsSpecified(), this);
		}
		

		RetrospectiveEffect.RetrospectiveEffectBuilder prune();
	}

	/*********************** Immutable Implementation of RetrospectiveEffect  ***********************/
	class RetrospectiveEffectImpl implements RetrospectiveEffect {
		private final ExceptionEnum standardisedException;
		private final String asSpecified;
		
		protected RetrospectiveEffectImpl(RetrospectiveEffect.RetrospectiveEffectBuilder builder) {
			this.standardisedException = builder.getStandardisedException();
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
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asSpecified")
		public String getAsSpecified() {
			return asSpecified;
		}
		
		@Override
		public RetrospectiveEffect build() {
			return this;
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder() {
			RetrospectiveEffect.RetrospectiveEffectBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RetrospectiveEffect.RetrospectiveEffectBuilder builder) {
			ofNullable(getStandardisedException()).ifPresent(builder::setStandardisedException);
			ofNullable(getAsSpecified()).ifPresent(builder::setAsSpecified);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrospectiveEffect _that = getType().cast(o);
		
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrospectiveEffect {" +
				"standardisedException=" + this.standardisedException + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}

	/*********************** Builder Implementation of RetrospectiveEffect  ***********************/
	class RetrospectiveEffectBuilderImpl implements RetrospectiveEffect.RetrospectiveEffectBuilder {
	
		protected ExceptionEnum standardisedException;
		protected String asSpecified;
		
		@Override
		@RosettaAttribute("standardisedException")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("standardisedException")
		public ExceptionEnum getStandardisedException() {
			return standardisedException;
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
		public RetrospectiveEffect.RetrospectiveEffectBuilder setStandardisedException(ExceptionEnum _standardisedException) {
			this.standardisedException = _standardisedException == null ? null : _standardisedException;
			return this;
		}
		
		@RosettaAttribute("asSpecified")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asSpecified")
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder setAsSpecified(String _asSpecified) {
			this.asSpecified = _asSpecified == null ? null : _asSpecified;
			return this;
		}
		
		@Override
		public RetrospectiveEffect build() {
			return new RetrospectiveEffect.RetrospectiveEffectImpl(this);
		}
		
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStandardisedException()!=null) return true;
			if (getAsSpecified()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RetrospectiveEffect.RetrospectiveEffectBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RetrospectiveEffect.RetrospectiveEffectBuilder o = (RetrospectiveEffect.RetrospectiveEffectBuilder) other;
			
			
			merger.mergeBasic(getStandardisedException(), o.getStandardisedException(), this::setStandardisedException);
			merger.mergeBasic(getAsSpecified(), o.getAsSpecified(), this::setAsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RetrospectiveEffect _that = getType().cast(o);
		
			if (!Objects.equals(standardisedException, _that.getStandardisedException())) return false;
			if (!Objects.equals(asSpecified, _that.getAsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (standardisedException != null ? standardisedException.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (asSpecified != null ? asSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RetrospectiveEffectBuilder {" +
				"standardisedException=" + this.standardisedException + ", " +
				"asSpecified=" + this.asSpecified +
			'}';
		}
	}
}
