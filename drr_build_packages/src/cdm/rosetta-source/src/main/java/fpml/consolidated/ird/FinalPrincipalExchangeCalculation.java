package fpml.consolidated.ird;

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
import fpml.consolidated.ird.meta.FinalPrincipalExchangeCalculationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Indicates whether the Principal Exchange on the inflation leg is floored or not. If TRUE, Principal Exchange takes the form: Inflation Notional Amount * Max(1, Index Final/ Index Base). If FALSE, the Principal Exchange takes the form: Inflation Notional Amount * Index Final / Index Base. Added for Inflation Asset Swap.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Indicates whether the Principal Exchange on the inflation leg is floored or not. If TRUE, Principal Exchange takes the form: Inflation Notional Amount * Max(1, Index Final/ Index Base). If FALSE, the Principal Exchange takes the form: Inflation Notional Amount * Index Final / Index Base. Added for Inflation Asset Swap.
 *
 */
@RosettaDataType(value="FinalPrincipalExchangeCalculation", builder=FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FinalPrincipalExchangeCalculation", model="fpml", builder=FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilderImpl.class, version="2.1.1")
public interface FinalPrincipalExchangeCalculation extends RosettaModelObject {

	FinalPrincipalExchangeCalculationMeta metaData = new FinalPrincipalExchangeCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If TRUE, Principal Exchange takes the form: Inflation Notional Amount * Max(1, Index Final/ Index Base). If FALSE, the Principal Exchange takes the form: Inflation Notional Amount * Index Final / Index Base.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If TRUE, Principal Exchange takes the form: Inflation Notional Amount * Max(1, Index Final/ Index Base). If FALSE, the Principal Exchange takes the form: Inflation Notional Amount * Index Final / Index Base.
	 *
	 */
	Boolean getFloored();

	/*********************** Build Methods  ***********************/
	FinalPrincipalExchangeCalculation build();
	
	FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder toBuilder();
	
	static FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder builder() {
		return new FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FinalPrincipalExchangeCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FinalPrincipalExchangeCalculation> getType() {
		return FinalPrincipalExchangeCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("floored"), Boolean.class, getFloored(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FinalPrincipalExchangeCalculationBuilder extends FinalPrincipalExchangeCalculation, RosettaModelObjectBuilder {
		FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder setFloored(Boolean floored);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("floored"), Boolean.class, getFloored(), this);
		}
		

		FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of FinalPrincipalExchangeCalculation  ***********************/
	class FinalPrincipalExchangeCalculationImpl implements FinalPrincipalExchangeCalculation {
		private final Boolean floored;
		
		protected FinalPrincipalExchangeCalculationImpl(FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder builder) {
			this.floored = builder.getFloored();
		}
		
		@Override
		@RosettaAttribute("floored")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floored")
		public Boolean getFloored() {
			return floored;
		}
		
		@Override
		public FinalPrincipalExchangeCalculation build() {
			return this;
		}
		
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder toBuilder() {
			FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder builder) {
			ofNullable(getFloored()).ifPresent(builder::setFloored);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalPrincipalExchangeCalculation _that = getType().cast(o);
		
			if (!Objects.equals(floored, _that.getFloored())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floored != null ? floored.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalPrincipalExchangeCalculation {" +
				"floored=" + this.floored +
			'}';
		}
	}

	/*********************** Builder Implementation of FinalPrincipalExchangeCalculation  ***********************/
	class FinalPrincipalExchangeCalculationBuilderImpl implements FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder {
	
		protected Boolean floored;
		
		@Override
		@RosettaAttribute("floored")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floored")
		public Boolean getFloored() {
			return floored;
		}
		
		@RosettaAttribute("floored")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floored")
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder setFloored(Boolean _floored) {
			this.floored = _floored == null ? null : _floored;
			return this;
		}
		
		@Override
		public FinalPrincipalExchangeCalculation build() {
			return new FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationImpl(this);
		}
		
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloored()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder o = (FinalPrincipalExchangeCalculation.FinalPrincipalExchangeCalculationBuilder) other;
			
			
			merger.mergeBasic(getFloored(), o.getFloored(), this::setFloored);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FinalPrincipalExchangeCalculation _that = getType().cast(o);
		
			if (!Objects.equals(floored, _that.getFloored())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floored != null ? floored.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FinalPrincipalExchangeCalculationBuilder {" +
				"floored=" + this.floored +
			'}';
		}
	}
}
