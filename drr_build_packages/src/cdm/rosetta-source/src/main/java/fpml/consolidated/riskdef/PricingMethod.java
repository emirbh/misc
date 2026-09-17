package fpml.consolidated.riskdef;

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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.riskdef.meta.PricingMethodMeta;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision For an asset (e.g. a reference/benchmark asset), the pricing structure used to price it. Used, for example, to specify that the rateIndex "USD-LIBOR-Telerate" with term = 6M is priced using the "USD-LIBOR-Close" curve.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision For an asset (e.g. a reference/benchmark asset), the pricing structure used to price it. Used, for example, to specify that the rateIndex "USD-LIBOR-Telerate" with term = 6M is priced using the "USD-LIBOR-Close" curve.
 *
 */
@RosettaDataType(value="PricingMethod", builder=PricingMethod.PricingMethodBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingMethod", model="fpml", builder=PricingMethod.PricingMethodBuilderImpl.class, version="2.1.1")
public interface PricingMethod extends RosettaModelObject {

	PricingMethodMeta metaData = new PricingMethodMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The asset whose price is required.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The asset whose price is required.
	 *
	 */
	AnyAssetReference getAssetReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the pricing input used to value the asset.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the pricing input used to value the asset.
	 *
	 */
	PricingStructureReference getPricingInputReference();

	/*********************** Build Methods  ***********************/
	PricingMethod build();
	
	PricingMethod.PricingMethodBuilder toBuilder();
	
	static PricingMethod.PricingMethodBuilder builder() {
		return new PricingMethod.PricingMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingMethod> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingMethod> getType() {
		return PricingMethod.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("assetReference"), processor, AnyAssetReference.class, getAssetReference());
		processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.class, getPricingInputReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingMethodBuilder extends PricingMethod, RosettaModelObjectBuilder {
		AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAssetReference();
		@Override
		AnyAssetReference.AnyAssetReferenceBuilder getAssetReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference();
		PricingMethod.PricingMethodBuilder setAssetReference(AnyAssetReference assetReference);
		PricingMethod.PricingMethodBuilder setPricingInputReference(PricingStructureReference pricingInputReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("assetReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getAssetReference());
			processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingInputReference());
		}
		

		PricingMethod.PricingMethodBuilder prune();
	}

	/*********************** Immutable Implementation of PricingMethod  ***********************/
	class PricingMethodImpl implements PricingMethod {
		private final AnyAssetReference assetReference;
		private final PricingStructureReference pricingInputReference;
		
		protected PricingMethodImpl(PricingMethod.PricingMethodBuilder builder) {
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
			this.pricingInputReference = ofNullable(builder.getPricingInputReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AnyAssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputReference")
		public PricingStructureReference getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingMethod build() {
			return this;
		}
		
		@Override
		public PricingMethod.PricingMethodBuilder toBuilder() {
			PricingMethod.PricingMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingMethod.PricingMethodBuilder builder) {
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
			ofNullable(getPricingInputReference()).ifPresent(builder::setPricingInputReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingMethod _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingMethod {" +
				"assetReference=" + this.assetReference + ", " +
				"pricingInputReference=" + this.pricingInputReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingMethod  ***********************/
	class PricingMethodBuilderImpl implements PricingMethod.PricingMethodBuilder {
	
		protected AnyAssetReference.AnyAssetReferenceBuilder assetReference;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingInputReference;
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AnyAssetReference.AnyAssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AnyAssetReference.AnyAssetReferenceBuilder getOrCreateAssetReference() {
			AnyAssetReference.AnyAssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AnyAssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingInputReference!=null) {
				result = pricingInputReference;
			}
			else {
				result = pricingInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetReference")
		@Override
		public PricingMethod.PricingMethodBuilder setAssetReference(AnyAssetReference _assetReference) {
			this.assetReference = _assetReference == null ? null : _assetReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingInputReference")
		@Override
		public PricingMethod.PricingMethodBuilder setPricingInputReference(PricingStructureReference _pricingInputReference) {
			this.pricingInputReference = _pricingInputReference == null ? null : _pricingInputReference.toBuilder();
			return this;
		}
		
		@Override
		public PricingMethod build() {
			return new PricingMethod.PricingMethodImpl(this);
		}
		
		@Override
		public PricingMethod.PricingMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingMethod.PricingMethodBuilder prune() {
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			if (pricingInputReference!=null && !pricingInputReference.prune().hasData()) pricingInputReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			if (getPricingInputReference()!=null && getPricingInputReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingMethod.PricingMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingMethod.PricingMethodBuilder o = (PricingMethod.PricingMethodBuilder) other;
			
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			merger.mergeRosetta(getPricingInputReference(), o.getPricingInputReference(), this::setPricingInputReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingMethod _that = getType().cast(o);
		
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingMethodBuilder {" +
				"assetReference=" + this.assetReference + ", " +
				"pricingInputReference=" + this.pricingInputReference +
			'}';
		}
	}
}
