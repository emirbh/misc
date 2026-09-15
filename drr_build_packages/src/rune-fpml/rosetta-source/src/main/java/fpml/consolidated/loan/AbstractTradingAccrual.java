package fpml.consolidated.loan;

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
import fpml.consolidated.loan.meta.AbstractTradingAccrualMeta;
import fpml.consolidated.shared.Money;
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
 * version "confirmation-5.13"
 *
 * Provision An underlying structure that details the elements that affect the calculation of a trade-related accrual.
 *
 */
@RosettaDataType(value="AbstractTradingAccrual", builder=AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AbstractTradingAccrual", model="fpml", builder=AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl.class, version="2.1.1")
public interface AbstractTradingAccrual extends RosettaModelObject {

	AbstractTradingAccrualMeta metaData = new AbstractTradingAccrualMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The total accrual amount.
	 *
	 */
	Money getAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision One or more accrual periods which reflect the constituent portions of the accrual amount.
	 *
	 */
	List<? extends AccrualPeriod> getAccrualPeriod();

	/*********************** Build Methods  ***********************/
	AbstractTradingAccrual build();
	
	AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder();
	
	static AbstractTradingAccrual.AbstractTradingAccrualBuilder builder() {
		return new AbstractTradingAccrual.AbstractTradingAccrualBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AbstractTradingAccrual> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AbstractTradingAccrual> getType() {
		return AbstractTradingAccrual.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.class, getAccrualPeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AbstractTradingAccrualBuilder extends AbstractTradingAccrual, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		@Override
		Money.MoneyBuilder getAmount();
		AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualPeriod(int index);
		@Override
		List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualPeriod();
		AbstractTradingAccrual.AbstractTradingAccrualBuilder setAmount(Money amount);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod accrualPeriod, int idx);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);
		AbstractTradingAccrual.AbstractTradingAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("accrualPeriod"), processor, AccrualPeriod.AccrualPeriodBuilder.class, getAccrualPeriod());
		}
		

		AbstractTradingAccrual.AbstractTradingAccrualBuilder prune();
	}

	/*********************** Immutable Implementation of AbstractTradingAccrual  ***********************/
	class AbstractTradingAccrualImpl implements AbstractTradingAccrual {
		private final Money amount;
		private final List<? extends AccrualPeriod> accrualPeriod;
		
		protected AbstractTradingAccrualImpl(AbstractTradingAccrual.AbstractTradingAccrualBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.accrualPeriod = ofNullable(builder.getAccrualPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public Money getAmount() {
			return amount;
		}
		
		@Override
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accrualPeriod")
		public List<? extends AccrualPeriod> getAccrualPeriod() {
			return accrualPeriod;
		}
		
		@Override
		public AbstractTradingAccrual build() {
			return this;
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder() {
			AbstractTradingAccrual.AbstractTradingAccrualBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AbstractTradingAccrual.AbstractTradingAccrualBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getAccrualPeriod()).ifPresent(builder::setAccrualPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTradingAccrual _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualPeriod, _that.getAccrualPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualPeriod != null ? accrualPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTradingAccrual {" +
				"amount=" + this.amount + ", " +
				"accrualPeriod=" + this.accrualPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of AbstractTradingAccrual  ***********************/
	class AbstractTradingAccrualBuilderImpl implements AbstractTradingAccrual.AbstractTradingAccrualBuilder {
	
		protected Money.MoneyBuilder amount;
		protected List<AccrualPeriod.AccrualPeriodBuilder> accrualPeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("amount")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("amount")
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("accrualPeriod")
		public List<? extends AccrualPeriod.AccrualPeriodBuilder> getAccrualPeriod() {
			return accrualPeriod;
		}
		
		@Override
		public AccrualPeriod.AccrualPeriodBuilder getOrCreateAccrualPeriod(int index) {
			if (accrualPeriod==null) {
				this.accrualPeriod = new ArrayList<>();
			}
			return getIndex(accrualPeriod, index, () -> {
						AccrualPeriod.AccrualPeriodBuilder newAccrualPeriod = AccrualPeriod.builder();
						return newAccrualPeriod;
					});
		}
		
		@RosettaAttribute("amount")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("amount")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder setAmount(Money _amount) {
			this.amount = _amount == null ? null : _amount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod) {
			if (_accrualPeriod != null) {
				this.accrualPeriod.add(_accrualPeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(AccrualPeriod _accrualPeriod, int idx) {
			getIndex(this.accrualPeriod, idx, () -> _accrualPeriod.toBuilder());
			return this;
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder addAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods != null) {
				for (final AccrualPeriod toAdd : accrualPeriods) {
					this.accrualPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("accrualPeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("accrualPeriod")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder setAccrualPeriod(List<? extends AccrualPeriod> accrualPeriods) {
			if (accrualPeriods == null) {
				this.accrualPeriod = new ArrayList<>();
			} else {
				this.accrualPeriod = accrualPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public AbstractTradingAccrual build() {
			return new AbstractTradingAccrual.AbstractTradingAccrualImpl(this);
		}
		
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			accrualPeriod = accrualPeriod.stream().filter(b->b!=null).<AccrualPeriod.AccrualPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getAccrualPeriod()!=null && getAccrualPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AbstractTradingAccrual.AbstractTradingAccrualBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AbstractTradingAccrual.AbstractTradingAccrualBuilder o = (AbstractTradingAccrual.AbstractTradingAccrualBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getAccrualPeriod(), o.getAccrualPeriod(), this::getOrCreateAccrualPeriod);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AbstractTradingAccrual _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!ListEquals.listEquals(accrualPeriod, _that.getAccrualPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (accrualPeriod != null ? accrualPeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AbstractTradingAccrualBuilder {" +
				"amount=" + this.amount + ", " +
				"accrualPeriod=" + this.accrualPeriod +
			'}';
		}
	}
}
