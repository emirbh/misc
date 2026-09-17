package fpml.consolidated.repo;

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
import fpml.consolidated.fpmlenum.MarginTypeEnum;
import fpml.consolidated.repo.meta.InitialMarginMeta;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines initial margin applied to a repo or SBL transaction. Initial margin is an agreed premium to the Purchase Price of a repo or the Leding Price of the SBL to determine the required Market Value of the collateral to be delivered on the Purchase or Delivery Date respectfully. It reflects quality of the collateral. Its aim is to calculate the risk-adjusted or liquidation value of collateral.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines initial margin applied to a repo or SBL transaction. Initial margin is an agreed premium to the Purchase Price of a repo or the Leding Price of the SBL to determine the required Market Value of the collateral to be delivered on the Purchase or Delivery Date respectfully. It reflects quality of the collateral. Its aim is to calculate the risk-adjusted or liquidation value of collateral.
 *
 */
@RosettaDataType(value="InitialMargin", builder=InitialMargin.InitialMarginBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InitialMargin", model="fpml", builder=InitialMargin.InitialMarginBuilderImpl.class, version="2.1.1")
public interface InitialMargin extends RosettaModelObject {

	InitialMarginMeta metaData = new InitialMarginMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining the type of assets (cash or securities) specified to apply as margin to the repo transaction. See GMRA 2011 paragraph 2(h) for "Cash Margin" and GMRA 2011 paragraph 2(cc) for "Margin Securities".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining the type of assets (cash or securities) specified to apply as margin to the repo transaction. See GMRA 2011 paragraph 2(h) for "Cash Margin" and GMRA 2011 paragraph 2(cc) for "Margin Securities".
	 *
	 */
	MarginTypeEnum getMarginType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Initial margin calculation for a collateral asset. Initial margin requirements may be specified for multiple pieces of collateral.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Initial margin calculation for a collateral asset. Initial margin requirements may be specified for multiple pieces of collateral.
	 *
	 */
	List<? extends InitialMarginCalculation> getMargin();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a margin threshold which is the Net Exposure of a trade below which parties agree they will not call a margin from each other.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a margin threshold which is the Net Exposure of a trade below which parties agree they will not call a margin from each other.
	 *
	 */
	NonNegativeMoney getMarginThreshold();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An element defining a minimum transfer amount which is the minimum margin call parties will make once the margin threshold (or margin ratio threshold / haircut threshold) has been exceeded.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An element defining a minimum transfer amount which is the minimum margin call parties will make once the margin threshold (or margin ratio threshold / haircut threshold) has been exceeded.
	 *
	 */
	NonNegativeMoney getMinimumTransferAmount();

	/*********************** Build Methods  ***********************/
	InitialMargin build();
	
	InitialMargin.InitialMarginBuilder toBuilder();
	
	static InitialMargin.InitialMarginBuilder builder() {
		return new InitialMargin.InitialMarginBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InitialMargin> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InitialMargin> getType() {
		return InitialMargin.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("marginType"), MarginTypeEnum.class, getMarginType(), this);
		processRosetta(path.newSubPath("margin"), processor, InitialMarginCalculation.class, getMargin());
		processRosetta(path.newSubPath("marginThreshold"), processor, NonNegativeMoney.class, getMarginThreshold());
		processRosetta(path.newSubPath("minimumTransferAmount"), processor, NonNegativeMoney.class, getMinimumTransferAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InitialMarginBuilder extends InitialMargin, RosettaModelObjectBuilder {
		InitialMarginCalculation.InitialMarginCalculationBuilder getOrCreateMargin(int index);
		@Override
		List<? extends InitialMarginCalculation.InitialMarginCalculationBuilder> getMargin();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMarginThreshold();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getMarginThreshold();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMinimumTransferAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getMinimumTransferAmount();
		InitialMargin.InitialMarginBuilder setMarginType(MarginTypeEnum marginType);
		InitialMargin.InitialMarginBuilder addMargin(InitialMarginCalculation margin);
		InitialMargin.InitialMarginBuilder addMargin(InitialMarginCalculation margin, int idx);
		InitialMargin.InitialMarginBuilder addMargin(List<? extends InitialMarginCalculation> margin);
		InitialMargin.InitialMarginBuilder setMargin(List<? extends InitialMarginCalculation> margin);
		InitialMargin.InitialMarginBuilder setMarginThreshold(NonNegativeMoney marginThreshold);
		InitialMargin.InitialMarginBuilder setMinimumTransferAmount(NonNegativeMoney minimumTransferAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("marginType"), MarginTypeEnum.class, getMarginType(), this);
			processRosetta(path.newSubPath("margin"), processor, InitialMarginCalculation.InitialMarginCalculationBuilder.class, getMargin());
			processRosetta(path.newSubPath("marginThreshold"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMarginThreshold());
			processRosetta(path.newSubPath("minimumTransferAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getMinimumTransferAmount());
		}
		

		InitialMargin.InitialMarginBuilder prune();
	}

	/*********************** Immutable Implementation of InitialMargin  ***********************/
	class InitialMarginImpl implements InitialMargin {
		private final MarginTypeEnum marginType;
		private final List<? extends InitialMarginCalculation> margin;
		private final NonNegativeMoney marginThreshold;
		private final NonNegativeMoney minimumTransferAmount;
		
		protected InitialMarginImpl(InitialMargin.InitialMarginBuilder builder) {
			this.marginType = builder.getMarginType();
			this.margin = ofNullable(builder.getMargin()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.marginThreshold = ofNullable(builder.getMarginThreshold()).map(f->f.build()).orElse(null);
			this.minimumTransferAmount = ofNullable(builder.getMinimumTransferAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("marginType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginType")
		public MarginTypeEnum getMarginType() {
			return marginType;
		}
		
		@Override
		@RosettaAttribute("margin")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("margin")
		public List<? extends InitialMarginCalculation> getMargin() {
			return margin;
		}
		
		@Override
		@RosettaAttribute("marginThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginThreshold")
		public NonNegativeMoney getMarginThreshold() {
			return marginThreshold;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumTransferAmount")
		public NonNegativeMoney getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		public InitialMargin build() {
			return this;
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder toBuilder() {
			InitialMargin.InitialMarginBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InitialMargin.InitialMarginBuilder builder) {
			ofNullable(getMarginType()).ifPresent(builder::setMarginType);
			ofNullable(getMargin()).ifPresent(builder::setMargin);
			ofNullable(getMarginThreshold()).ifPresent(builder::setMarginThreshold);
			ofNullable(getMinimumTransferAmount()).ifPresent(builder::setMinimumTransferAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMargin _that = getType().cast(o);
		
			if (!Objects.equals(marginType, _that.getMarginType())) return false;
			if (!ListEquals.listEquals(margin, _that.getMargin())) return false;
			if (!Objects.equals(marginThreshold, _that.getMarginThreshold())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginType != null ? marginType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (margin != null ? margin.hashCode() : 0);
			_result = 31 * _result + (marginThreshold != null ? marginThreshold.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMargin {" +
				"marginType=" + this.marginType + ", " +
				"margin=" + this.margin + ", " +
				"marginThreshold=" + this.marginThreshold + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of InitialMargin  ***********************/
	class InitialMarginBuilderImpl implements InitialMargin.InitialMarginBuilder {
	
		protected MarginTypeEnum marginType;
		protected List<InitialMarginCalculation.InitialMarginCalculationBuilder> margin = new ArrayList<>();
		protected NonNegativeMoney.NonNegativeMoneyBuilder marginThreshold;
		protected NonNegativeMoney.NonNegativeMoneyBuilder minimumTransferAmount;
		
		@Override
		@RosettaAttribute("marginType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("marginType")
		public MarginTypeEnum getMarginType() {
			return marginType;
		}
		
		@Override
		@RosettaAttribute("margin")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("margin")
		public List<? extends InitialMarginCalculation.InitialMarginCalculationBuilder> getMargin() {
			return margin;
		}
		
		@Override
		public InitialMarginCalculation.InitialMarginCalculationBuilder getOrCreateMargin(int index) {
			if (margin==null) {
				this.margin = new ArrayList<>();
			}
			return getIndex(margin, index, () -> {
						InitialMarginCalculation.InitialMarginCalculationBuilder newMargin = InitialMarginCalculation.builder();
						return newMargin;
					});
		}
		
		@Override
		@RosettaAttribute("marginThreshold")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marginThreshold")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMarginThreshold() {
			return marginThreshold;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMarginThreshold() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (marginThreshold!=null) {
				result = marginThreshold;
			}
			else {
				result = marginThreshold = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumTransferAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getMinimumTransferAmount() {
			return minimumTransferAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateMinimumTransferAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (minimumTransferAmount!=null) {
				result = minimumTransferAmount;
			}
			else {
				result = minimumTransferAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("marginType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("marginType")
		@Override
		public InitialMargin.InitialMarginBuilder setMarginType(MarginTypeEnum _marginType) {
			this.marginType = _marginType == null ? null : _marginType;
			return this;
		}
		
		@RosettaAttribute("margin")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("margin")
		@Override
		public InitialMargin.InitialMarginBuilder addMargin(InitialMarginCalculation _margin) {
			if (_margin != null) {
				this.margin.add(_margin.toBuilder());
			}
			return this;
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder addMargin(InitialMarginCalculation _margin, int idx) {
			getIndex(this.margin, idx, () -> _margin.toBuilder());
			return this;
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder addMargin(List<? extends InitialMarginCalculation> margins) {
			if (margins != null) {
				for (final InitialMarginCalculation toAdd : margins) {
					this.margin.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("margin")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("margin")
		@Override
		public InitialMargin.InitialMarginBuilder setMargin(List<? extends InitialMarginCalculation> margins) {
			if (margins == null) {
				this.margin = new ArrayList<>();
			} else {
				this.margin = margins.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("marginThreshold")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marginThreshold")
		@Override
		public InitialMargin.InitialMarginBuilder setMarginThreshold(NonNegativeMoney _marginThreshold) {
			this.marginThreshold = _marginThreshold == null ? null : _marginThreshold.toBuilder();
			return this;
		}
		
		@RosettaAttribute("minimumTransferAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumTransferAmount")
		@Override
		public InitialMargin.InitialMarginBuilder setMinimumTransferAmount(NonNegativeMoney _minimumTransferAmount) {
			this.minimumTransferAmount = _minimumTransferAmount == null ? null : _minimumTransferAmount.toBuilder();
			return this;
		}
		
		@Override
		public InitialMargin build() {
			return new InitialMargin.InitialMarginImpl(this);
		}
		
		@Override
		public InitialMargin.InitialMarginBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMargin.InitialMarginBuilder prune() {
			margin = margin.stream().filter(b->b!=null).<InitialMarginCalculation.InitialMarginCalculationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (marginThreshold!=null && !marginThreshold.prune().hasData()) marginThreshold = null;
			if (minimumTransferAmount!=null && !minimumTransferAmount.prune().hasData()) minimumTransferAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMarginType()!=null) return true;
			if (getMargin()!=null && getMargin().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarginThreshold()!=null && getMarginThreshold().hasData()) return true;
			if (getMinimumTransferAmount()!=null && getMinimumTransferAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InitialMargin.InitialMarginBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InitialMargin.InitialMarginBuilder o = (InitialMargin.InitialMarginBuilder) other;
			
			merger.mergeRosetta(getMargin(), o.getMargin(), this::getOrCreateMargin);
			merger.mergeRosetta(getMarginThreshold(), o.getMarginThreshold(), this::setMarginThreshold);
			merger.mergeRosetta(getMinimumTransferAmount(), o.getMinimumTransferAmount(), this::setMinimumTransferAmount);
			
			merger.mergeBasic(getMarginType(), o.getMarginType(), this::setMarginType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InitialMargin _that = getType().cast(o);
		
			if (!Objects.equals(marginType, _that.getMarginType())) return false;
			if (!ListEquals.listEquals(margin, _that.getMargin())) return false;
			if (!Objects.equals(marginThreshold, _that.getMarginThreshold())) return false;
			if (!Objects.equals(minimumTransferAmount, _that.getMinimumTransferAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (marginType != null ? marginType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (margin != null ? margin.hashCode() : 0);
			_result = 31 * _result + (marginThreshold != null ? marginThreshold.hashCode() : 0);
			_result = 31 * _result + (minimumTransferAmount != null ? minimumTransferAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InitialMarginBuilder {" +
				"marginType=" + this.marginType + ", " +
				"margin=" + this.margin + ", " +
				"marginThreshold=" + this.marginThreshold + ", " +
				"minimumTransferAmount=" + this.minimumTransferAmount +
			'}';
		}
	}
}
