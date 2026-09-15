package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.SpecifiedCurrencyMeta;
import fpml.consolidated.shared.Currency;
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
@RosettaDataType(value="SpecifiedCurrency", builder=SpecifiedCurrency.SpecifiedCurrencyBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SpecifiedCurrency", model="fpml", builder=SpecifiedCurrency.SpecifiedCurrencyBuilderImpl.class, version="2.1.1")
public interface SpecifiedCurrency extends RosettaModelObject {

	SpecifiedCurrencyMeta metaData = new SpecifiedCurrencyMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates whether the specified currency provision is applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates whether the specified currency provision is applicable.
	 *
	 */
	Boolean getApplicable();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency in which an amount is denominated.
	 *
	 */
	List<? extends Currency> getCurrency();

	/*********************** Build Methods  ***********************/
	SpecifiedCurrency build();
	
	SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder();
	
	static SpecifiedCurrency.SpecifiedCurrencyBuilder builder() {
		return new SpecifiedCurrency.SpecifiedCurrencyBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SpecifiedCurrency> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SpecifiedCurrency> getType() {
		return SpecifiedCurrency.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("currency"), processor, Currency.class, getCurrency());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SpecifiedCurrencyBuilder extends SpecifiedCurrency, RosettaModelObjectBuilder {
		Currency.CurrencyBuilder getOrCreateCurrency(int index);
		@Override
		List<? extends Currency.CurrencyBuilder> getCurrency();
		SpecifiedCurrency.SpecifiedCurrencyBuilder setApplicable(Boolean applicable);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency currency, int idx);
		SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(List<? extends Currency> currency);
		SpecifiedCurrency.SpecifiedCurrencyBuilder setCurrency(List<? extends Currency> currency);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("currency"), processor, Currency.CurrencyBuilder.class, getCurrency());
		}
		

		SpecifiedCurrency.SpecifiedCurrencyBuilder prune();
	}

	/*********************** Immutable Implementation of SpecifiedCurrency  ***********************/
	class SpecifiedCurrencyImpl implements SpecifiedCurrency {
		private final Boolean applicable;
		private final List<? extends Currency> currency;
		
		protected SpecifiedCurrencyImpl(SpecifiedCurrency.SpecifiedCurrencyBuilder builder) {
			this.applicable = builder.getApplicable();
			this.currency = ofNullable(builder.getCurrency()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("currency")
		public List<? extends Currency> getCurrency() {
			return currency;
		}
		
		@Override
		public SpecifiedCurrency build() {
			return this;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder() {
			SpecifiedCurrency.SpecifiedCurrencyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedCurrency.SpecifiedCurrencyBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedCurrency {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}

	/*********************** Builder Implementation of SpecifiedCurrency  ***********************/
	class SpecifiedCurrencyBuilderImpl implements SpecifiedCurrency.SpecifiedCurrencyBuilder {
	
		protected Boolean applicable;
		protected List<Currency.CurrencyBuilder> currency = new ArrayList<>();
		
		@Override
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("currency")
		public List<? extends Currency.CurrencyBuilder> getCurrency() {
			return currency;
		}
		
		@Override
		public Currency.CurrencyBuilder getOrCreateCurrency(int index) {
			if (currency==null) {
				this.currency = new ArrayList<>();
			}
			return getIndex(currency, index, () -> {
						Currency.CurrencyBuilder newCurrency = Currency.builder();
						return newCurrency;
					});
		}
		
		@RosettaAttribute("applicable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicable")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder setApplicable(Boolean _applicable) {
			this.applicable = _applicable == null ? null : _applicable;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("currency")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency _currency) {
			if (_currency != null) {
				this.currency.add(_currency.toBuilder());
			}
			return this;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(Currency _currency, int idx) {
			getIndex(this.currency, idx, () -> _currency.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder addCurrency(List<? extends Currency> currencys) {
			if (currencys != null) {
				for (final Currency toAdd : currencys) {
					this.currency.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("currency")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder setCurrency(List<? extends Currency> currencys) {
			if (currencys == null) {
				this.currency = new ArrayList<>();
			} else {
				this.currency = currencys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SpecifiedCurrency build() {
			return new SpecifiedCurrency.SpecifiedCurrencyImpl(this);
		}
		
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder prune() {
			currency = currency.stream().filter(b->b!=null).<Currency.CurrencyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getCurrency()!=null && getCurrency().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedCurrency.SpecifiedCurrencyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedCurrency.SpecifiedCurrencyBuilder o = (SpecifiedCurrency.SpecifiedCurrencyBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::getOrCreateCurrency);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedCurrency _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!ListEquals.listEquals(currency, _that.getCurrency())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedCurrencyBuilder {" +
				"applicable=" + this.applicable + ", " +
				"currency=" + this.currency +
			'}';
		}
	}
}
