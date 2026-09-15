package fpml.consolidated.reg.fpmlreporting.shared;

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
import fpml.consolidated.reg.fpmlreporting.shared.meta.CollateralPortfolioMeta;
import fpml.consolidated.shared.PositiveMoney;
import java.time.ZonedDateTime;
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
 * Provision The CollateralPortfolio component provides the ability to specify the collateral in support of the transaction reporting as of a particular value date. It includes unbounded choice of cash or nonCash collateral. This model would allow mixing cash and non-cash collateral without any regards to order. In real life transaction, you almost always see some cash or a collection of non-cash collateral blocs.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The CollateralPortfolio component provides the ability to specify the collateral in support of the transaction reporting as of a particular value date. It includes unbounded choice of cash or nonCash collateral. This model would allow mixing cash and non-cash collateral without any regards to order. In real life transaction, you almost always see some cash or a collection of non-cash collateral blocs.
 *
 */
@RosettaDataType(value="CollateralPortfolio", builder=CollateralPortfolio.CollateralPortfolioBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CollateralPortfolio", model="fpml", builder=CollateralPortfolio.CollateralPortfolioBuilderImpl.class, version="2.1.1")
public interface CollateralPortfolio extends RosettaModelObject {

	CollateralPortfolioMeta metaData = new CollateralPortfolioMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ZonedDateTime getValueDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends CollateralPortfolioChoice> getCollateralPortfolioChoice();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Represents aggregated Market / Fair Value amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Represents aggregated Market / Fair Value amount.
	 *
	 */
	List<? extends PositiveMoney> getTotalValuationAmount();

	/*********************** Build Methods  ***********************/
	CollateralPortfolio build();
	
	CollateralPortfolio.CollateralPortfolioBuilder toBuilder();
	
	static CollateralPortfolio.CollateralPortfolioBuilder builder() {
		return new CollateralPortfolio.CollateralPortfolioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralPortfolio> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CollateralPortfolio> getType() {
		return CollateralPortfolio.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
		processRosetta(path.newSubPath("collateralPortfolioChoice"), processor, CollateralPortfolioChoice.class, getCollateralPortfolioChoice());
		processRosetta(path.newSubPath("totalValuationAmount"), processor, PositiveMoney.class, getTotalValuationAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralPortfolioBuilder extends CollateralPortfolio, RosettaModelObjectBuilder {
		CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder getOrCreateCollateralPortfolioChoice(int index);
		@Override
		List<? extends CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder> getCollateralPortfolioChoice();
		PositiveMoney.PositiveMoneyBuilder getOrCreateTotalValuationAmount(int index);
		@Override
		List<? extends PositiveMoney.PositiveMoneyBuilder> getTotalValuationAmount();
		CollateralPortfolio.CollateralPortfolioBuilder setValueDate(ZonedDateTime valueDate);
		CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(CollateralPortfolioChoice collateralPortfolioChoice);
		CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(CollateralPortfolioChoice collateralPortfolioChoice, int idx);
		CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(List<? extends CollateralPortfolioChoice> collateralPortfolioChoice);
		CollateralPortfolio.CollateralPortfolioBuilder setCollateralPortfolioChoice(List<? extends CollateralPortfolioChoice> collateralPortfolioChoice);
		CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(PositiveMoney totalValuationAmount);
		CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(PositiveMoney totalValuationAmount, int idx);
		CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(List<? extends PositiveMoney> totalValuationAmount);
		CollateralPortfolio.CollateralPortfolioBuilder setTotalValuationAmount(List<? extends PositiveMoney> totalValuationAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("valueDate"), ZonedDateTime.class, getValueDate(), this);
			processRosetta(path.newSubPath("collateralPortfolioChoice"), processor, CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder.class, getCollateralPortfolioChoice());
			processRosetta(path.newSubPath("totalValuationAmount"), processor, PositiveMoney.PositiveMoneyBuilder.class, getTotalValuationAmount());
		}
		

		CollateralPortfolio.CollateralPortfolioBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralPortfolio  ***********************/
	class CollateralPortfolioImpl implements CollateralPortfolio {
		private final ZonedDateTime valueDate;
		private final List<? extends CollateralPortfolioChoice> collateralPortfolioChoice;
		private final List<? extends PositiveMoney> totalValuationAmount;
		
		protected CollateralPortfolioImpl(CollateralPortfolio.CollateralPortfolioBuilder builder) {
			this.valueDate = builder.getValueDate();
			this.collateralPortfolioChoice = ofNullable(builder.getCollateralPortfolioChoice()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalValuationAmount = ofNullable(builder.getTotalValuationAmount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralPortfolioChoice")
		public List<? extends CollateralPortfolioChoice> getCollateralPortfolioChoice() {
			return collateralPortfolioChoice;
		}
		
		@Override
		@RosettaAttribute("totalValuationAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("totalValuationAmount")
		public List<? extends PositiveMoney> getTotalValuationAmount() {
			return totalValuationAmount;
		}
		
		@Override
		public CollateralPortfolio build() {
			return this;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder toBuilder() {
			CollateralPortfolio.CollateralPortfolioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralPortfolio.CollateralPortfolioBuilder builder) {
			ofNullable(getValueDate()).ifPresent(builder::setValueDate);
			ofNullable(getCollateralPortfolioChoice()).ifPresent(builder::setCollateralPortfolioChoice);
			ofNullable(getTotalValuationAmount()).ifPresent(builder::setTotalValuationAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolio _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!ListEquals.listEquals(collateralPortfolioChoice, _that.getCollateralPortfolioChoice())) return false;
			if (!ListEquals.listEquals(totalValuationAmount, _that.getTotalValuationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioChoice != null ? collateralPortfolioChoice.hashCode() : 0);
			_result = 31 * _result + (totalValuationAmount != null ? totalValuationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolio {" +
				"valueDate=" + this.valueDate + ", " +
				"collateralPortfolioChoice=" + this.collateralPortfolioChoice + ", " +
				"totalValuationAmount=" + this.totalValuationAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralPortfolio  ***********************/
	class CollateralPortfolioBuilderImpl implements CollateralPortfolio.CollateralPortfolioBuilder {
	
		protected ZonedDateTime valueDate;
		protected List<CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder> collateralPortfolioChoice = new ArrayList<>();
		protected List<PositiveMoney.PositiveMoneyBuilder> totalValuationAmount = new ArrayList<>();
		
		@Override
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("valueDate")
		public ZonedDateTime getValueDate() {
			return valueDate;
		}
		
		@Override
		@RosettaAttribute("collateralPortfolioChoice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("collateralPortfolioChoice")
		public List<? extends CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder> getCollateralPortfolioChoice() {
			return collateralPortfolioChoice;
		}
		
		@Override
		public CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder getOrCreateCollateralPortfolioChoice(int index) {
			if (collateralPortfolioChoice==null) {
				this.collateralPortfolioChoice = new ArrayList<>();
			}
			return getIndex(collateralPortfolioChoice, index, () -> {
						CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder newCollateralPortfolioChoice = CollateralPortfolioChoice.builder();
						return newCollateralPortfolioChoice;
					});
		}
		
		@Override
		@RosettaAttribute("totalValuationAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("totalValuationAmount")
		public List<? extends PositiveMoney.PositiveMoneyBuilder> getTotalValuationAmount() {
			return totalValuationAmount;
		}
		
		@Override
		public PositiveMoney.PositiveMoneyBuilder getOrCreateTotalValuationAmount(int index) {
			if (totalValuationAmount==null) {
				this.totalValuationAmount = new ArrayList<>();
			}
			return getIndex(totalValuationAmount, index, () -> {
						PositiveMoney.PositiveMoneyBuilder newTotalValuationAmount = PositiveMoney.builder();
						return newTotalValuationAmount;
					});
		}
		
		@RosettaAttribute("valueDate")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valueDate")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder setValueDate(ZonedDateTime _valueDate) {
			this.valueDate = _valueDate == null ? null : _valueDate;
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioChoice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("collateralPortfolioChoice")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(CollateralPortfolioChoice _collateralPortfolioChoice) {
			if (_collateralPortfolioChoice != null) {
				this.collateralPortfolioChoice.add(_collateralPortfolioChoice.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(CollateralPortfolioChoice _collateralPortfolioChoice, int idx) {
			getIndex(this.collateralPortfolioChoice, idx, () -> _collateralPortfolioChoice.toBuilder());
			return this;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addCollateralPortfolioChoice(List<? extends CollateralPortfolioChoice> collateralPortfolioChoices) {
			if (collateralPortfolioChoices != null) {
				for (final CollateralPortfolioChoice toAdd : collateralPortfolioChoices) {
					this.collateralPortfolioChoice.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("collateralPortfolioChoice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("collateralPortfolioChoice")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder setCollateralPortfolioChoice(List<? extends CollateralPortfolioChoice> collateralPortfolioChoices) {
			if (collateralPortfolioChoices == null) {
				this.collateralPortfolioChoice = new ArrayList<>();
			} else {
				this.collateralPortfolioChoice = collateralPortfolioChoices.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalValuationAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("totalValuationAmount")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(PositiveMoney _totalValuationAmount) {
			if (_totalValuationAmount != null) {
				this.totalValuationAmount.add(_totalValuationAmount.toBuilder());
			}
			return this;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(PositiveMoney _totalValuationAmount, int idx) {
			getIndex(this.totalValuationAmount, idx, () -> _totalValuationAmount.toBuilder());
			return this;
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder addTotalValuationAmount(List<? extends PositiveMoney> totalValuationAmounts) {
			if (totalValuationAmounts != null) {
				for (final PositiveMoney toAdd : totalValuationAmounts) {
					this.totalValuationAmount.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("totalValuationAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("totalValuationAmount")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder setTotalValuationAmount(List<? extends PositiveMoney> totalValuationAmounts) {
			if (totalValuationAmounts == null) {
				this.totalValuationAmount = new ArrayList<>();
			} else {
				this.totalValuationAmount = totalValuationAmounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CollateralPortfolio build() {
			return new CollateralPortfolio.CollateralPortfolioImpl(this);
		}
		
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder prune() {
			collateralPortfolioChoice = collateralPortfolioChoice.stream().filter(b->b!=null).<CollateralPortfolioChoice.CollateralPortfolioChoiceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			totalValuationAmount = totalValuationAmount.stream().filter(b->b!=null).<PositiveMoney.PositiveMoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValueDate()!=null) return true;
			if (getCollateralPortfolioChoice()!=null && getCollateralPortfolioChoice().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalValuationAmount()!=null && getTotalValuationAmount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralPortfolio.CollateralPortfolioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralPortfolio.CollateralPortfolioBuilder o = (CollateralPortfolio.CollateralPortfolioBuilder) other;
			
			merger.mergeRosetta(getCollateralPortfolioChoice(), o.getCollateralPortfolioChoice(), this::getOrCreateCollateralPortfolioChoice);
			merger.mergeRosetta(getTotalValuationAmount(), o.getTotalValuationAmount(), this::getOrCreateTotalValuationAmount);
			
			merger.mergeBasic(getValueDate(), o.getValueDate(), this::setValueDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralPortfolio _that = getType().cast(o);
		
			if (!Objects.equals(valueDate, _that.getValueDate())) return false;
			if (!ListEquals.listEquals(collateralPortfolioChoice, _that.getCollateralPortfolioChoice())) return false;
			if (!ListEquals.listEquals(totalValuationAmount, _that.getTotalValuationAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valueDate != null ? valueDate.hashCode() : 0);
			_result = 31 * _result + (collateralPortfolioChoice != null ? collateralPortfolioChoice.hashCode() : 0);
			_result = 31 * _result + (totalValuationAmount != null ? totalValuationAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralPortfolioBuilder {" +
				"valueDate=" + this.valueDate + ", " +
				"collateralPortfolioChoice=" + this.collateralPortfolioChoice + ", " +
				"totalValuationAmount=" + this.totalValuationAmount +
			'}';
		}
	}
}
