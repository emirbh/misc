package fpml.consolidated.repo;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.repo.meta.InitialMarginCalculationMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the initial margin calculation applicable to a single piece of collateral.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the initial margin calculation applicable to a single piece of collateral.
 *
 */
@RosettaDataType(value="InitialMarginCalculation", builder=InitialMarginCalculation.InitialMarginCalculationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InitialMarginCalculation", model="fpml", builder=InitialMarginCalculation.InitialMarginCalculationBuilderImpl.class, version="2.1.1")
public interface InitialMarginCalculation extends RosettaModelObject {

	InitialMarginCalculationMeta metaData = new InitialMarginCalculationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining an initial margin expressed as a ratio of the Market Value of the collateral to the Purchase Price. A default value of initial margin ratio of 1.00 means there is no margin and thus no risk related with the collateral. See GMRA 2000 paragraph 2(z) and GMRA 2011 paragraph 2(bb).
	 *
	 */
	BigDecimal getMarginRatio();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a margin ratio threshold which is the value above (when it's lower than initial margin ratio) or below (when it's higher than initial margin ratio) which parties agree they will not call a margin from each other.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a margin ratio threshold which is the value above (when it's lower than initial margin ratio) or below (when it's higher than initial margin ratio) which parties agree they will not call a margin from each other.
	 *
	 */
	List<BigDecimal> getMarginRatioThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the repo and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the repo to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a haircut expressed as the percentage difference between the Market Value of the collateral and the Purchase Price of the repo and calculated as 100 multiplied by a ratio of the difference between the Market Value of the collateral and the Purchase Price of the repo to the Market Value of the collateral. Haircut is alternative way to adjust the value of collateral sold in a repurchase agreement to initial margin ratio. Because an initial margin is a percentage of the Purchase Price, while a haircut is a percentage of the Market Value of collateral, the arithmetic of initial margins and haircuts is slightly different. For example, an initial margin of 102% is not equivalent to a haircut of 2%, but to 1.961% (ie 100/102%). See GMRA 2011 paragraph 2(aa).
	 *
	 */
	BigDecimal getHaircut();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a haircut percentage threshold which is the value above (when it's lower than initial haircut) or below (when it's higher than initial haircut) which parties agree they will not call a margin from each other.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a haircut percentage threshold which is the value above (when it's lower than initial haircut) or below (when it's higher than initial haircut) which parties agree they will not call a margin from each other.
	 *
	 */
	List<BigDecimal> getHaircutThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the collateral asset to which the margin requirement applies. This element should be produced in the case where margin requirements are specified for multiple pieces of collateral, and may be omitted otherwise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the collateral asset to which the margin requirement applies. This element should be produced in the case where margin requirements are specified for multiple pieces of collateral, and may be omitted otherwise.
	 *
	 */
	AssetReference getAssetReference();

	/*********************** Build Methods  ***********************/
	InitialMarginCalculation build();
	
	InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder();
	
	static InitialMarginCalculation.InitialMarginCalculationBuilder builder() {
		return new InitialMarginCalculation.InitialMarginCalculationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialMarginCalculation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InitialMarginCalculation> getType() {
		return InitialMarginCalculation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
		processor.processBasic(path.newSubPath("marginRatioThreshold"), BigDecimal.class, getMarginRatioThreshold(), this);
		processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
		processor.processBasic(path.newSubPath("haircutThreshold"), BigDecimal.class, getHaircutThreshold(), this);
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialMarginCalculationBuilder extends InitialMarginCalculation, RosettaModelObjectBuilder {
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		@Override
		AssetReference.AssetReferenceBuilder getAssetReference();
		InitialMarginCalculation.InitialMarginCalculationBuilder setMarginRatio(BigDecimal marginRatio);
		InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(BigDecimal marginRatioThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(BigDecimal marginRatioThreshold, int idx);
		InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(List<BigDecimal> marginRatioThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder setMarginRatioThreshold(List<BigDecimal> marginRatioThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder setHaircut(BigDecimal haircut);
		InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(BigDecimal haircutThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(BigDecimal haircutThreshold, int idx);
		InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(List<BigDecimal> haircutThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder setHaircutThreshold(List<BigDecimal> haircutThreshold);
		InitialMarginCalculation.InitialMarginCalculationBuilder setAssetReference(AssetReference assetReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marginRatio"), BigDecimal.class, getMarginRatio(), this);
			processor.processBasic(path.newSubPath("marginRatioThreshold"), BigDecimal.class, getMarginRatioThreshold(), this);
			processor.processBasic(path.newSubPath("haircut"), BigDecimal.class, getHaircut(), this);
			processor.processBasic(path.newSubPath("haircutThreshold"), BigDecimal.class, getHaircutThreshold(), this);
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
		}
		

		InitialMarginCalculation.InitialMarginCalculationBuilder prune();
	}

	/*********************** Immutable Implementation of InitialMarginCalculation  ***********************/
	class InitialMarginCalculationImpl implements InitialMarginCalculation {
		private final BigDecimal marginRatio;
		private final List<BigDecimal> marginRatioThreshold;
		private final BigDecimal haircut;
		private final List<BigDecimal> haircutThreshold;
		private final AssetReference assetReference;
		
		protected InitialMarginCalculationImpl(InitialMarginCalculation.InitialMarginCalculationBuilder builder) {
			this.marginRatio = builder.getMarginRatio();
			this.marginRatioThreshold = ofNullable(builder.getMarginRatioThreshold()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.haircut = builder.getHaircut();
			this.haircutThreshold = ofNullable(builder.getHaircutThreshold()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("marginRatioThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("marginRatioThreshold")
		public List<BigDecimal> getMarginRatioThreshold() {
			return marginRatioThreshold;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("haircutThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("haircutThreshold")
		public List<BigDecimal> getHaircutThreshold() {
			return haircutThreshold;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		public InitialMarginCalculation build() {
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder() {
			InitialMarginCalculation.InitialMarginCalculationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialMarginCalculation.InitialMarginCalculationBuilder builder) {
			ofNullable(getMarginRatio()).ifPresent(builder::setMarginRatio);
			ofNullable(getMarginRatioThreshold()).ifPresent(builder::setMarginRatioThreshold);
			ofNullable(getHaircut()).ifPresent(builder::setHaircut);
			ofNullable(getHaircutThreshold()).ifPresent(builder::setHaircutThreshold);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculation _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!ListEquals.listEquals(marginRatioThreshold, _that.getMarginRatioThreshold())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!ListEquals.listEquals(haircutThreshold, _that.getHaircutThreshold())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (marginRatioThreshold != null ? marginRatioThreshold.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (haircutThreshold != null ? haircutThreshold.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculation {" +
				"marginRatio=" + this.marginRatio + ", " +
				"marginRatioThreshold=" + this.marginRatioThreshold + ", " +
				"haircut=" + this.haircut + ", " +
				"haircutThreshold=" + this.haircutThreshold + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}

	/*********************** Builder Implementation of InitialMarginCalculation  ***********************/
	class InitialMarginCalculationBuilderImpl implements InitialMarginCalculation.InitialMarginCalculationBuilder {
	
		protected BigDecimal marginRatio;
		protected List<BigDecimal> marginRatioThreshold = new ArrayList<>();
		protected BigDecimal haircut;
		protected List<BigDecimal> haircutThreshold = new ArrayList<>();
		protected AssetReference.AssetReferenceBuilder assetReference;
		
		@Override
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginRatio")
		public BigDecimal getMarginRatio() {
			return marginRatio;
		}
		
		@Override
		@RosettaAttribute("marginRatioThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("marginRatioThreshold")
		public List<BigDecimal> getMarginRatioThreshold() {
			return marginRatioThreshold;
		}
		
		@Override
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("haircut")
		public BigDecimal getHaircut() {
			return haircut;
		}
		
		@Override
		@RosettaAttribute("haircutThreshold")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("haircutThreshold")
		public List<BigDecimal> getHaircutThreshold() {
			return haircutThreshold;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("marginRatio")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marginRatio")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder setMarginRatio(BigDecimal _marginRatio) {
			this.marginRatio = _marginRatio == null ? null : _marginRatio;
			return this;
		}
		
		@RosettaAttribute("marginRatioThreshold")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("marginRatioThreshold")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(BigDecimal _marginRatioThreshold) {
			if (_marginRatioThreshold != null) {
				this.marginRatioThreshold.add(_marginRatioThreshold);
			}
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(BigDecimal _marginRatioThreshold, int idx) {
			getIndex(this.marginRatioThreshold, idx, () -> _marginRatioThreshold);
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addMarginRatioThreshold(List<BigDecimal> marginRatioThresholds) {
			if (marginRatioThresholds != null) {
				for (final BigDecimal toAdd : marginRatioThresholds) {
					this.marginRatioThreshold.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("marginRatioThreshold")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("marginRatioThreshold")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder setMarginRatioThreshold(List<BigDecimal> marginRatioThresholds) {
			if (marginRatioThresholds == null) {
				this.marginRatioThreshold = new ArrayList<>();
			} else {
				this.marginRatioThreshold = marginRatioThresholds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("haircut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("haircut")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder setHaircut(BigDecimal _haircut) {
			this.haircut = _haircut == null ? null : _haircut;
			return this;
		}
		
		@RosettaAttribute("haircutThreshold")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("haircutThreshold")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(BigDecimal _haircutThreshold) {
			if (_haircutThreshold != null) {
				this.haircutThreshold.add(_haircutThreshold);
			}
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(BigDecimal _haircutThreshold, int idx) {
			getIndex(this.haircutThreshold, idx, () -> _haircutThreshold);
			return this;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder addHaircutThreshold(List<BigDecimal> haircutThresholds) {
			if (haircutThresholds != null) {
				for (final BigDecimal toAdd : haircutThresholds) {
					this.haircutThreshold.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("haircutThreshold")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("haircutThreshold")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder setHaircutThreshold(List<BigDecimal> haircutThresholds) {
			if (haircutThresholds == null) {
				this.haircutThreshold = new ArrayList<>();
			} else {
				this.haircutThreshold = haircutThresholds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetReference")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder setAssetReference(AssetReference _assetReference) {
			this.assetReference = _assetReference == null ? null : _assetReference.toBuilder();
			return this;
		}
		
		@Override
		public InitialMarginCalculation build() {
			return new InitialMarginCalculation.InitialMarginCalculationImpl(this);
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder prune() {
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarginRatio()!=null) return true;
			if (getMarginRatioThreshold()!=null && !getMarginRatioThreshold().isEmpty()) return true;
			if (getHaircut()!=null) return true;
			if (getHaircutThreshold()!=null && !getHaircutThreshold().isEmpty()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InitialMarginCalculation.InitialMarginCalculationBuilder o = (InitialMarginCalculation.InitialMarginCalculationBuilder) other;
			
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			
			merger.mergeBasic(getMarginRatio(), o.getMarginRatio(), this::setMarginRatio);
			merger.mergeBasic(getMarginRatioThreshold(), o.getMarginRatioThreshold(), (Consumer<BigDecimal>) this::addMarginRatioThreshold);
			merger.mergeBasic(getHaircut(), o.getHaircut(), this::setHaircut);
			merger.mergeBasic(getHaircutThreshold(), o.getHaircutThreshold(), (Consumer<BigDecimal>) this::addHaircutThreshold);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMarginCalculation _that = getType().cast(o);
		
			if (!Objects.equals(marginRatio, _that.getMarginRatio())) return false;
			if (!ListEquals.listEquals(marginRatioThreshold, _that.getMarginRatioThreshold())) return false;
			if (!Objects.equals(haircut, _that.getHaircut())) return false;
			if (!ListEquals.listEquals(haircutThreshold, _that.getHaircutThreshold())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginRatio != null ? marginRatio.hashCode() : 0);
			_result = 31 * _result + (marginRatioThreshold != null ? marginRatioThreshold.hashCode() : 0);
			_result = 31 * _result + (haircut != null ? haircut.hashCode() : 0);
			_result = 31 * _result + (haircutThreshold != null ? haircutThreshold.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginCalculationBuilder {" +
				"marginRatio=" + this.marginRatio + ", " +
				"marginRatioThreshold=" + this.marginRatioThreshold + ", " +
				"haircut=" + this.haircut + ", " +
				"haircutThreshold=" + this.haircutThreshold + ", " +
				"assetReference=" + this.assetReference +
			'}';
		}
	}
}
