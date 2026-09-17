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
import fpml.consolidated.fpmlenum.SpreadCalculationMethodEnum;
import fpml.consolidated.ird.meta.SwapAdditionalTermsMeta;
import fpml.consolidated.shared.SwapStreamReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Additional terms to a swap contract. If the Swap AdditionalTerms container is empty, there is no additional terms
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Additional terms to a swap contract. If the Swap AdditionalTerms container is empty, there is no additional terms
 *
 */
@RosettaDataType(value="SwapAdditionalTerms", builder=SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SwapAdditionalTerms", model="fpml", builder=SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl.class, version="2.1.1")
public interface SwapAdditionalTerms extends RosettaModelObject {

	SwapAdditionalTermsMeta metaData = new SwapAdditionalTermsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a bond underlyer to represent an asset swap or Condition Precedent Bond.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a bond underlyer to represent an asset swap or Condition Precedent Bond.
	 *
	 */
	BondReference getBondReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Method by which asset swap spread is calculated, par-par or proceeds.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Method by which asset swap spread is calculated, par-par or proceeds.
	 *
	 */
	SpreadCalculationMethodEnum getSpreadCalculationMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to a leg linked to this bond underlyer to represent an Inflation linked asset swap. Added for Inflation Asset Swap
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to a leg linked to this bond underlyer to represent an Inflation linked asset swap. Added for Inflation Asset Swap
	 *
	 */
	SwapStreamReference getSwapStreamReference();

	/*********************** Build Methods  ***********************/
	SwapAdditionalTerms build();
	
	SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder();
	
	static SwapAdditionalTerms.SwapAdditionalTermsBuilder builder() {
		return new SwapAdditionalTerms.SwapAdditionalTermsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SwapAdditionalTerms> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SwapAdditionalTerms> getType() {
		return SwapAdditionalTerms.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("bondReference"), processor, BondReference.class, getBondReference());
		processor.processBasic(path.newSubPath("spreadCalculationMethod"), SpreadCalculationMethodEnum.class, getSpreadCalculationMethod(), this);
		processRosetta(path.newSubPath("swapStreamReference"), processor, SwapStreamReference.class, getSwapStreamReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SwapAdditionalTermsBuilder extends SwapAdditionalTerms, RosettaModelObjectBuilder {
		BondReference.BondReferenceBuilder getOrCreateBondReference();
		@Override
		BondReference.BondReferenceBuilder getBondReference();
		SwapStreamReference.SwapStreamReferenceBuilder getOrCreateSwapStreamReference();
		@Override
		SwapStreamReference.SwapStreamReferenceBuilder getSwapStreamReference();
		SwapAdditionalTerms.SwapAdditionalTermsBuilder setBondReference(BondReference bondReference);
		SwapAdditionalTerms.SwapAdditionalTermsBuilder setSpreadCalculationMethod(SpreadCalculationMethodEnum spreadCalculationMethod);
		SwapAdditionalTerms.SwapAdditionalTermsBuilder setSwapStreamReference(SwapStreamReference swapStreamReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("bondReference"), processor, BondReference.BondReferenceBuilder.class, getBondReference());
			processor.processBasic(path.newSubPath("spreadCalculationMethod"), SpreadCalculationMethodEnum.class, getSpreadCalculationMethod(), this);
			processRosetta(path.newSubPath("swapStreamReference"), processor, SwapStreamReference.SwapStreamReferenceBuilder.class, getSwapStreamReference());
		}
		

		SwapAdditionalTerms.SwapAdditionalTermsBuilder prune();
	}

	/*********************** Immutable Implementation of SwapAdditionalTerms  ***********************/
	class SwapAdditionalTermsImpl implements SwapAdditionalTerms {
		private final BondReference bondReference;
		private final SpreadCalculationMethodEnum spreadCalculationMethod;
		private final SwapStreamReference swapStreamReference;
		
		protected SwapAdditionalTermsImpl(SwapAdditionalTerms.SwapAdditionalTermsBuilder builder) {
			this.bondReference = ofNullable(builder.getBondReference()).map(f->f.build()).orElse(null);
			this.spreadCalculationMethod = builder.getSpreadCalculationMethod();
			this.swapStreamReference = ofNullable(builder.getSwapStreamReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("bondReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bondReference")
		public BondReference getBondReference() {
			return bondReference;
		}
		
		@Override
		@RosettaAttribute("spreadCalculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadCalculationMethod")
		public SpreadCalculationMethodEnum getSpreadCalculationMethod() {
			return spreadCalculationMethod;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapStreamReference")
		public SwapStreamReference getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public SwapAdditionalTerms build() {
			return this;
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder() {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SwapAdditionalTerms.SwapAdditionalTermsBuilder builder) {
			ofNullable(getBondReference()).ifPresent(builder::setBondReference);
			ofNullable(getSpreadCalculationMethod()).ifPresent(builder::setSpreadCalculationMethod);
			ofNullable(getSwapStreamReference()).ifPresent(builder::setSwapStreamReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			if (!Objects.equals(spreadCalculationMethod, _that.getSpreadCalculationMethod())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			_result = 31 * _result + (spreadCalculationMethod != null ? spreadCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapAdditionalTerms {" +
				"bondReference=" + this.bondReference + ", " +
				"spreadCalculationMethod=" + this.spreadCalculationMethod + ", " +
				"swapStreamReference=" + this.swapStreamReference +
			'}';
		}
	}

	/*********************** Builder Implementation of SwapAdditionalTerms  ***********************/
	class SwapAdditionalTermsBuilderImpl implements SwapAdditionalTerms.SwapAdditionalTermsBuilder {
	
		protected BondReference.BondReferenceBuilder bondReference;
		protected SpreadCalculationMethodEnum spreadCalculationMethod;
		protected SwapStreamReference.SwapStreamReferenceBuilder swapStreamReference;
		
		@Override
		@RosettaAttribute("bondReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("bondReference")
		public BondReference.BondReferenceBuilder getBondReference() {
			return bondReference;
		}
		
		@Override
		public BondReference.BondReferenceBuilder getOrCreateBondReference() {
			BondReference.BondReferenceBuilder result;
			if (bondReference!=null) {
				result = bondReference;
			}
			else {
				result = bondReference = BondReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("spreadCalculationMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("spreadCalculationMethod")
		public SpreadCalculationMethodEnum getSpreadCalculationMethod() {
			return spreadCalculationMethod;
		}
		
		@Override
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("swapStreamReference")
		public SwapStreamReference.SwapStreamReferenceBuilder getSwapStreamReference() {
			return swapStreamReference;
		}
		
		@Override
		public SwapStreamReference.SwapStreamReferenceBuilder getOrCreateSwapStreamReference() {
			SwapStreamReference.SwapStreamReferenceBuilder result;
			if (swapStreamReference!=null) {
				result = swapStreamReference;
			}
			else {
				result = swapStreamReference = SwapStreamReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("bondReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("bondReference")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder setBondReference(BondReference _bondReference) {
			this.bondReference = _bondReference == null ? null : _bondReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spreadCalculationMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spreadCalculationMethod")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder setSpreadCalculationMethod(SpreadCalculationMethodEnum _spreadCalculationMethod) {
			this.spreadCalculationMethod = _spreadCalculationMethod == null ? null : _spreadCalculationMethod;
			return this;
		}
		
		@RosettaAttribute("swapStreamReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("swapStreamReference")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder setSwapStreamReference(SwapStreamReference _swapStreamReference) {
			this.swapStreamReference = _swapStreamReference == null ? null : _swapStreamReference.toBuilder();
			return this;
		}
		
		@Override
		public SwapAdditionalTerms build() {
			return new SwapAdditionalTerms.SwapAdditionalTermsImpl(this);
		}
		
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder prune() {
			if (bondReference!=null && !bondReference.prune().hasData()) bondReference = null;
			if (swapStreamReference!=null && !swapStreamReference.prune().hasData()) swapStreamReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBondReference()!=null && getBondReference().hasData()) return true;
			if (getSpreadCalculationMethod()!=null) return true;
			if (getSwapStreamReference()!=null && getSwapStreamReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SwapAdditionalTerms.SwapAdditionalTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SwapAdditionalTerms.SwapAdditionalTermsBuilder o = (SwapAdditionalTerms.SwapAdditionalTermsBuilder) other;
			
			merger.mergeRosetta(getBondReference(), o.getBondReference(), this::setBondReference);
			merger.mergeRosetta(getSwapStreamReference(), o.getSwapStreamReference(), this::setSwapStreamReference);
			
			merger.mergeBasic(getSpreadCalculationMethod(), o.getSpreadCalculationMethod(), this::setSpreadCalculationMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SwapAdditionalTerms _that = getType().cast(o);
		
			if (!Objects.equals(bondReference, _that.getBondReference())) return false;
			if (!Objects.equals(spreadCalculationMethod, _that.getSpreadCalculationMethod())) return false;
			if (!Objects.equals(swapStreamReference, _that.getSwapStreamReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bondReference != null ? bondReference.hashCode() : 0);
			_result = 31 * _result + (spreadCalculationMethod != null ? spreadCalculationMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (swapStreamReference != null ? swapStreamReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SwapAdditionalTermsBuilder {" +
				"bondReference=" + this.bondReference + ", " +
				"spreadCalculationMethod=" + this.spreadCalculationMethod + ", " +
				"swapStreamReference=" + this.swapStreamReference +
			'}';
		}
	}
}
