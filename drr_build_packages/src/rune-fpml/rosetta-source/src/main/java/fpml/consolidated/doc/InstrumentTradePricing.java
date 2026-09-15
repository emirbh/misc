package fpml.consolidated.doc;

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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.doc.meta.InstrumentTradePricingMeta;
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
 * Provision A structure describing the price paid for the instrument.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A structure describing the price paid for the instrument.
 *
 */
@RosettaDataType(value="InstrumentTradePricing", builder=InstrumentTradePricing.InstrumentTradePricingBuilderImpl.class, version="2.1.1")
@RuneDataType(value="InstrumentTradePricing", model="fpml", builder=InstrumentTradePricing.InstrumentTradePricingBuilderImpl.class, version="2.1.1")
public interface InstrumentTradePricing extends RosettaModelObject {

	InstrumentTradePricingMeta metaData = new InstrumentTradePricingMeta();

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
	List<? extends BasicQuotation> getQuote();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date interest started accruing for the accrued interest calculation on an interest bearing security.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date interest started accruing for the accrued interest calculation on an interest bearing security.
	 *
	 */
	ZonedDateTime getCouponStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date when a distribution of dividends or interest is deducted from a securities asset, or set aside for payment to the original bondholders. From the ex-date, any dividends that are owing on the security are paid to the original owner. As a consequence of this, on the ex-date, the securities price typically drops by the amount of the distribution (plus or minus any market activity).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date when a distribution of dividends or interest is deducted from a securities asset, or set aside for payment to the original bondholders. From the ex-date, any dividends that are owing on the security are paid to the original owner. As a consequence of this, on the ex-date, the securities price typically drops by the amount of the distribution (plus or minus any market activity).
	 *
	 */
	ZonedDateTime getExDividendDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the accrued interest in included when the trade settles. ("true" means accrued interest is not included when the trade settles.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the accrued interest in included when the trade settles. ("true" means accrued interest is not included when the trade settles.)
	 *
	 */
	Boolean getTradedFlatOfAccrued();

	/*********************** Build Methods  ***********************/
	InstrumentTradePricing build();
	
	InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder();
	
	static InstrumentTradePricing.InstrumentTradePricingBuilder builder() {
		return new InstrumentTradePricing.InstrumentTradePricingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentTradePricing> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InstrumentTradePricing> getType() {
		return InstrumentTradePricing.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processor.processBasic(path.newSubPath("couponStartDate"), ZonedDateTime.class, getCouponStartDate(), this);
		processor.processBasic(path.newSubPath("exDividendDate"), ZonedDateTime.class, getExDividendDate(), this);
		processor.processBasic(path.newSubPath("tradedFlatOfAccrued"), Boolean.class, getTradedFlatOfAccrued(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentTradePricingBuilder extends InstrumentTradePricing, RosettaModelObjectBuilder {
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote);
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation quote, int idx);
		InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(List<? extends BasicQuotation> quote);
		InstrumentTradePricing.InstrumentTradePricingBuilder setQuote(List<? extends BasicQuotation> quote);
		InstrumentTradePricing.InstrumentTradePricingBuilder setCouponStartDate(ZonedDateTime couponStartDate);
		InstrumentTradePricing.InstrumentTradePricingBuilder setExDividendDate(ZonedDateTime exDividendDate);
		InstrumentTradePricing.InstrumentTradePricingBuilder setTradedFlatOfAccrued(Boolean tradedFlatOfAccrued);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processor.processBasic(path.newSubPath("couponStartDate"), ZonedDateTime.class, getCouponStartDate(), this);
			processor.processBasic(path.newSubPath("exDividendDate"), ZonedDateTime.class, getExDividendDate(), this);
			processor.processBasic(path.newSubPath("tradedFlatOfAccrued"), Boolean.class, getTradedFlatOfAccrued(), this);
		}
		

		InstrumentTradePricing.InstrumentTradePricingBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentTradePricing  ***********************/
	class InstrumentTradePricingImpl implements InstrumentTradePricing {
		private final List<? extends BasicQuotation> quote;
		private final ZonedDateTime couponStartDate;
		private final ZonedDateTime exDividendDate;
		private final Boolean tradedFlatOfAccrued;
		
		protected InstrumentTradePricingImpl(InstrumentTradePricing.InstrumentTradePricingBuilder builder) {
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.couponStartDate = builder.getCouponStartDate();
			this.exDividendDate = builder.getExDividendDate();
			this.tradedFlatOfAccrued = builder.getTradedFlatOfAccrued();
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("couponStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponStartDate")
		public ZonedDateTime getCouponStartDate() {
			return couponStartDate;
		}
		
		@Override
		@RosettaAttribute("exDividendDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exDividendDate")
		public ZonedDateTime getExDividendDate() {
			return exDividendDate;
		}
		
		@Override
		@RosettaAttribute("tradedFlatOfAccrued")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradedFlatOfAccrued")
		public Boolean getTradedFlatOfAccrued() {
			return tradedFlatOfAccrued;
		}
		
		@Override
		public InstrumentTradePricing build() {
			return this;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder() {
			InstrumentTradePricing.InstrumentTradePricingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentTradePricing.InstrumentTradePricingBuilder builder) {
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getCouponStartDate()).ifPresent(builder::setCouponStartDate);
			ofNullable(getExDividendDate()).ifPresent(builder::setExDividendDate);
			ofNullable(getTradedFlatOfAccrued()).ifPresent(builder::setTradedFlatOfAccrued);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePricing _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(couponStartDate, _that.getCouponStartDate())) return false;
			if (!Objects.equals(exDividendDate, _that.getExDividendDate())) return false;
			if (!Objects.equals(tradedFlatOfAccrued, _that.getTradedFlatOfAccrued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
			_result = 31 * _result + (exDividendDate != null ? exDividendDate.hashCode() : 0);
			_result = 31 * _result + (tradedFlatOfAccrued != null ? tradedFlatOfAccrued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePricing {" +
				"quote=" + this.quote + ", " +
				"couponStartDate=" + this.couponStartDate + ", " +
				"exDividendDate=" + this.exDividendDate + ", " +
				"tradedFlatOfAccrued=" + this.tradedFlatOfAccrued +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentTradePricing  ***********************/
	class InstrumentTradePricingBuilderImpl implements InstrumentTradePricing.InstrumentTradePricingBuilder {
	
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected ZonedDateTime couponStartDate;
		protected ZonedDateTime exDividendDate;
		protected Boolean tradedFlatOfAccrued;
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("couponStartDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("couponStartDate")
		public ZonedDateTime getCouponStartDate() {
			return couponStartDate;
		}
		
		@Override
		@RosettaAttribute("exDividendDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exDividendDate")
		public ZonedDateTime getExDividendDate() {
			return exDividendDate;
		}
		
		@Override
		@RosettaAttribute("tradedFlatOfAccrued")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradedFlatOfAccrued")
		public Boolean getTradedFlatOfAccrued() {
			return tradedFlatOfAccrued;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("couponStartDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("couponStartDate")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder setCouponStartDate(ZonedDateTime _couponStartDate) {
			this.couponStartDate = _couponStartDate == null ? null : _couponStartDate;
			return this;
		}
		
		@RosettaAttribute("exDividendDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exDividendDate")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder setExDividendDate(ZonedDateTime _exDividendDate) {
			this.exDividendDate = _exDividendDate == null ? null : _exDividendDate;
			return this;
		}
		
		@RosettaAttribute("tradedFlatOfAccrued")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradedFlatOfAccrued")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder setTradedFlatOfAccrued(Boolean _tradedFlatOfAccrued) {
			this.tradedFlatOfAccrued = _tradedFlatOfAccrued == null ? null : _tradedFlatOfAccrued;
			return this;
		}
		
		@Override
		public InstrumentTradePricing build() {
			return new InstrumentTradePricing.InstrumentTradePricingImpl(this);
		}
		
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder prune() {
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCouponStartDate()!=null) return true;
			if (getExDividendDate()!=null) return true;
			if (getTradedFlatOfAccrued()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentTradePricing.InstrumentTradePricingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentTradePricing.InstrumentTradePricingBuilder o = (InstrumentTradePricing.InstrumentTradePricingBuilder) other;
			
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			
			merger.mergeBasic(getCouponStartDate(), o.getCouponStartDate(), this::setCouponStartDate);
			merger.mergeBasic(getExDividendDate(), o.getExDividendDate(), this::setExDividendDate);
			merger.mergeBasic(getTradedFlatOfAccrued(), o.getTradedFlatOfAccrued(), this::setTradedFlatOfAccrued);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentTradePricing _that = getType().cast(o);
		
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(couponStartDate, _that.getCouponStartDate())) return false;
			if (!Objects.equals(exDividendDate, _that.getExDividendDate())) return false;
			if (!Objects.equals(tradedFlatOfAccrued, _that.getTradedFlatOfAccrued())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (couponStartDate != null ? couponStartDate.hashCode() : 0);
			_result = 31 * _result + (exDividendDate != null ? exDividendDate.hashCode() : 0);
			_result = 31 * _result + (tradedFlatOfAccrued != null ? tradedFlatOfAccrued.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentTradePricingBuilder {" +
				"quote=" + this.quote + ", " +
				"couponStartDate=" + this.couponStartDate + ", " +
				"exDividendDate=" + this.exDividendDate + ", " +
				"tradedFlatOfAccrued=" + this.tradedFlatOfAccrued +
			'}';
		}
	}
}
