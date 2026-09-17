package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.mktenv.meta.VolatilityRepresentationMeta;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.PricingStructure;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A representation of volatilities of an asset. This is a generic structure whose values can be supplied in a specific volatility matrix.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A representation of volatilities of an asset. This is a generic structure whose values can be supplied in a specific volatility matrix.
 *
 */
@RosettaDataType(value="VolatilityRepresentation", builder=VolatilityRepresentation.VolatilityRepresentationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityRepresentation", model="fpml", builder=VolatilityRepresentation.VolatilityRepresentationBuilderImpl.class, version="2.1.1")
public interface VolatilityRepresentation extends PricingStructure {

	VolatilityRepresentationMeta metaData = new VolatilityRepresentationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the asset whose volatility is modeled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the asset whose volatility is modeled.
	 *
	 */
	AssetReference getAsset();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the yield curve whose volatility is modeled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the yield curve whose volatility is modeled.
	 *
	 */
	YieldCurveReference getYieldCurveReference();

	/*********************** Build Methods  ***********************/
	VolatilityRepresentation build();
	
	VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder();
	
	static VolatilityRepresentation.VolatilityRepresentationBuilder builder() {
		return new VolatilityRepresentation.VolatilityRepresentationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityRepresentation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityRepresentation> getType() {
		return VolatilityRepresentation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
		processRosetta(path.newSubPath("asset"), processor, AssetReference.class, getAsset());
		processRosetta(path.newSubPath("yieldCurveReference"), processor, YieldCurveReference.class, getYieldCurveReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityRepresentationBuilder extends VolatilityRepresentation, PricingStructure.PricingStructureBuilder {
		AssetReference.AssetReferenceBuilder getOrCreateAsset();
		@Override
		AssetReference.AssetReferenceBuilder getAsset();
		YieldCurveReference.YieldCurveReferenceBuilder getOrCreateYieldCurveReference();
		@Override
		YieldCurveReference.YieldCurveReferenceBuilder getYieldCurveReference();
		@Override
		VolatilityRepresentation.VolatilityRepresentationBuilder setId(String id);
		@Override
		VolatilityRepresentation.VolatilityRepresentationBuilder setName(String name);
		@Override
		VolatilityRepresentation.VolatilityRepresentationBuilder setCurrency(Currency currency);
		VolatilityRepresentation.VolatilityRepresentationBuilder setAsset(AssetReference asset);
		VolatilityRepresentation.VolatilityRepresentationBuilder setYieldCurveReference(YieldCurveReference yieldCurveReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
			processRosetta(path.newSubPath("asset"), processor, AssetReference.AssetReferenceBuilder.class, getAsset());
			processRosetta(path.newSubPath("yieldCurveReference"), processor, YieldCurveReference.YieldCurveReferenceBuilder.class, getYieldCurveReference());
		}
		

		VolatilityRepresentation.VolatilityRepresentationBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityRepresentation  ***********************/
	class VolatilityRepresentationImpl extends PricingStructure.PricingStructureImpl implements VolatilityRepresentation {
		private final AssetReference asset;
		private final YieldCurveReference yieldCurveReference;
		
		protected VolatilityRepresentationImpl(VolatilityRepresentation.VolatilityRepresentationBuilder builder) {
			super(builder);
			this.asset = ofNullable(builder.getAsset()).map(f->f.build()).orElse(null);
			this.yieldCurveReference = ofNullable(builder.getYieldCurveReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("asset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asset")
		public AssetReference getAsset() {
			return asset;
		}
		
		@Override
		@RosettaAttribute("yieldCurveReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yieldCurveReference")
		public YieldCurveReference getYieldCurveReference() {
			return yieldCurveReference;
		}
		
		@Override
		public VolatilityRepresentation build() {
			return this;
		}
		
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder() {
			VolatilityRepresentation.VolatilityRepresentationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityRepresentation.VolatilityRepresentationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAsset()).ifPresent(builder::setAsset);
			ofNullable(getYieldCurveReference()).ifPresent(builder::setYieldCurveReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(yieldCurveReference, _that.getYieldCurveReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (yieldCurveReference != null ? yieldCurveReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityRepresentation {" +
				"asset=" + this.asset + ", " +
				"yieldCurveReference=" + this.yieldCurveReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityRepresentation  ***********************/
	class VolatilityRepresentationBuilderImpl extends PricingStructure.PricingStructureBuilderImpl implements VolatilityRepresentation.VolatilityRepresentationBuilder {
	
		protected AssetReference.AssetReferenceBuilder asset;
		protected YieldCurveReference.YieldCurveReferenceBuilder yieldCurveReference;
		
		@Override
		@RosettaAttribute("asset")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asset")
		public AssetReference.AssetReferenceBuilder getAsset() {
			return asset;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAsset() {
			AssetReference.AssetReferenceBuilder result;
			if (asset!=null) {
				result = asset;
			}
			else {
				result = asset = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("yieldCurveReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("yieldCurveReference")
		public YieldCurveReference.YieldCurveReferenceBuilder getYieldCurveReference() {
			return yieldCurveReference;
		}
		
		@Override
		public YieldCurveReference.YieldCurveReferenceBuilder getOrCreateYieldCurveReference() {
			YieldCurveReference.YieldCurveReferenceBuilder result;
			if (yieldCurveReference!=null) {
				result = yieldCurveReference;
			}
			else {
				result = yieldCurveReference = YieldCurveReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("currency")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder setCurrency(Currency _currency) {
			this.currency = _currency == null ? null : _currency.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asset")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asset")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder setAsset(AssetReference _asset) {
			this.asset = _asset == null ? null : _asset.toBuilder();
			return this;
		}
		
		@RosettaAttribute("yieldCurveReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("yieldCurveReference")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder setYieldCurveReference(YieldCurveReference _yieldCurveReference) {
			this.yieldCurveReference = _yieldCurveReference == null ? null : _yieldCurveReference.toBuilder();
			return this;
		}
		
		@Override
		public VolatilityRepresentation build() {
			return new VolatilityRepresentation.VolatilityRepresentationImpl(this);
		}
		
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder prune() {
			super.prune();
			if (asset!=null && !asset.prune().hasData()) asset = null;
			if (yieldCurveReference!=null && !yieldCurveReference.prune().hasData()) yieldCurveReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAsset()!=null && getAsset().hasData()) return true;
			if (getYieldCurveReference()!=null && getYieldCurveReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityRepresentation.VolatilityRepresentationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilityRepresentation.VolatilityRepresentationBuilder o = (VolatilityRepresentation.VolatilityRepresentationBuilder) other;
			
			merger.mergeRosetta(getAsset(), o.getAsset(), this::setAsset);
			merger.mergeRosetta(getYieldCurveReference(), o.getYieldCurveReference(), this::setYieldCurveReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityRepresentation _that = getType().cast(o);
		
			if (!Objects.equals(asset, _that.getAsset())) return false;
			if (!Objects.equals(yieldCurveReference, _that.getYieldCurveReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (asset != null ? asset.hashCode() : 0);
			_result = 31 * _result + (yieldCurveReference != null ? yieldCurveReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityRepresentationBuilder {" +
				"asset=" + this.asset + ", " +
				"yieldCurveReference=" + this.yieldCurveReference +
			'}' + " " + super.toString();
		}
	}
}
