package cdm.legaldocumentation.csa;

import cdm.legaldocumentation.csa.meta.FinalReturnsMeta;
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
 * A clause providing that final return collateral is to be provided without consideration of any Minimum Transfer Amount and collateral haircut.
 * @version 6.23.0
 */
@RosettaDataType(value="FinalReturns", builder=FinalReturns.FinalReturnsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FinalReturns", model="cdm", builder=FinalReturns.FinalReturnsBuilderImpl.class, version="6.23.0")
public interface FinalReturns extends RosettaModelObject {

	FinalReturnsMeta metaData = new FinalReturnsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines if the clause is applicable to this agreement or any other exceptions.
	 */
	Boolean getApplicable();
	/**
	 * The additional language that might be specified by the parties to the legal agreement.
	 */
	String getAdditionalLanguage();

	/*********************** Build Methods  ***********************/
	FinalReturns build();
	
	FinalReturns.FinalReturnsBuilder toBuilder();
	
	static FinalReturns.FinalReturnsBuilder builder() {
		return new FinalReturns.FinalReturnsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinalReturns> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinalReturns> getType() {
		return FinalReturns.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinalReturnsBuilder extends FinalReturns, RosettaModelObjectBuilder {
		FinalReturns.FinalReturnsBuilder setApplicable(Boolean applicable);
		FinalReturns.FinalReturnsBuilder setAdditionalLanguage(String additionalLanguage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processor.processBasic(path.newSubPath("additionalLanguage"), String.class, getAdditionalLanguage(), this);
		}
		

		FinalReturns.FinalReturnsBuilder prune();
	}

	/*********************** Immutable Implementation of FinalReturns  ***********************/
	class FinalReturnsImpl implements FinalReturns {
		private final Boolean applicable;
		private final String additionalLanguage;
		
		protected FinalReturnsImpl(FinalReturns.FinalReturnsBuilder builder) {
			this.applicable = builder.getApplicable();
			this.additionalLanguage = builder.getAdditionalLanguage();
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@Override
		public FinalReturns build() {
			return this;
		}
		
		@Override
		public FinalReturns.FinalReturnsBuilder toBuilder() {
			FinalReturns.FinalReturnsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinalReturns.FinalReturnsBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getAdditionalLanguage()).ifPresent(builder::setAdditionalLanguage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalReturns _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalReturns {" +
				"applicable=" + this.applicable + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}

	/*********************** Builder Implementation of FinalReturns  ***********************/
	class FinalReturnsBuilderImpl implements FinalReturns.FinalReturnsBuilder {
	
		protected Boolean applicable;
		protected String additionalLanguage;
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalLanguage")
		public String getAdditionalLanguage() {
			return additionalLanguage;
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public FinalReturns.FinalReturnsBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("additionalLanguage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalLanguage")
		@Override
		public FinalReturns.FinalReturnsBuilder setAdditionalLanguage(String _additionalLanguage) {
			this.additionalLanguage = _additionalLanguage == null ? null : _additionalLanguage;
			return this;
		}
		
		@Override
		public FinalReturns build() {
			return new FinalReturns.FinalReturnsImpl(this);
		}
		
		@Override
		public FinalReturns.FinalReturnsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalReturns.FinalReturnsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getAdditionalLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalReturns.FinalReturnsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinalReturns.FinalReturnsBuilder o = (FinalReturns.FinalReturnsBuilder) other;
			
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			merger.mergeBasic(getAdditionalLanguage(), o.getAdditionalLanguage(), this::setAdditionalLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalReturns _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(additionalLanguage, _that.getAdditionalLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (additionalLanguage != null ? additionalLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalReturnsBuilder {" +
				"applicable=" + this.applicable + ", " +
				"additionalLanguage=" + this.additionalLanguage +
			'}';
		}
	}
}
