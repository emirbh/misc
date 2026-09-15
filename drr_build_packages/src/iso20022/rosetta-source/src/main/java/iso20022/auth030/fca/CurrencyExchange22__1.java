package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.CurrencyExchange22__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the details of the currency exchange.
 * @version ${project.version}
 */
@RosettaDataType(value="CurrencyExchange22__1", builder=CurrencyExchange22__1.CurrencyExchange22__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CurrencyExchange22__1", model="iso20022", builder=CurrencyExchange22__1.CurrencyExchange22__1BuilderImpl.class, version="${project.version}")
public interface CurrencyExchange22__1 extends RosettaModelObject {

	CurrencyExchange22__1Meta metaData = new CurrencyExchange22__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the exchange rate between the two currencies specified in the derivative transaction agreed by the counterparties at the inception of the transaction,  expressed as the rate of exchange from converting the unit currency into the quoted currency.
	 */
	BigDecimal getXchgRate();
	/**
	 * Forward exchange rate as agreed between the counterparties in the contractual agreement, expressed as a price of base currency in the quoted currency.
	 */
	BigDecimal getFwdXchgRate();
	/**
	 * Indicates, for equity options, commodity options and similar products, the currency in which the strike price is denominated.  In case of foreign exchange options, indicates the currency pair and order in which the strike price is expressed as unit currency and quoted currency.
	 */
	ExchangeRateBasis1Choice__1 getXchgRateBsis();

	/*********************** Build Methods  ***********************/
	CurrencyExchange22__1 build();
	
	CurrencyExchange22__1.CurrencyExchange22__1Builder toBuilder();
	
	static CurrencyExchange22__1.CurrencyExchange22__1Builder builder() {
		return new CurrencyExchange22__1.CurrencyExchange22__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurrencyExchange22__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CurrencyExchange22__1> getType() {
		return CurrencyExchange22__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("xchgRate"), BigDecimal.class, getXchgRate(), this);
		processor.processBasic(path.newSubPath("fwdXchgRate"), BigDecimal.class, getFwdXchgRate(), this);
		processRosetta(path.newSubPath("xchgRateBsis"), processor, ExchangeRateBasis1Choice__1.class, getXchgRateBsis());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrencyExchange22__1Builder extends CurrencyExchange22__1, RosettaModelObjectBuilder {
		ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder getOrCreateXchgRateBsis();
		@Override
		ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder getXchgRateBsis();
		CurrencyExchange22__1.CurrencyExchange22__1Builder setXchgRate(BigDecimal xchgRate);
		CurrencyExchange22__1.CurrencyExchange22__1Builder setFwdXchgRate(BigDecimal fwdXchgRate);
		CurrencyExchange22__1.CurrencyExchange22__1Builder setXchgRateBsis(ExchangeRateBasis1Choice__1 xchgRateBsis);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("xchgRate"), BigDecimal.class, getXchgRate(), this);
			processor.processBasic(path.newSubPath("fwdXchgRate"), BigDecimal.class, getFwdXchgRate(), this);
			processRosetta(path.newSubPath("xchgRateBsis"), processor, ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder.class, getXchgRateBsis());
		}
		

		CurrencyExchange22__1.CurrencyExchange22__1Builder prune();
	}

	/*********************** Immutable Implementation of CurrencyExchange22__1  ***********************/
	class CurrencyExchange22__1Impl implements CurrencyExchange22__1 {
		private final BigDecimal xchgRate;
		private final BigDecimal fwdXchgRate;
		private final ExchangeRateBasis1Choice__1 xchgRateBsis;
		
		protected CurrencyExchange22__1Impl(CurrencyExchange22__1.CurrencyExchange22__1Builder builder) {
			this.xchgRate = builder.getXchgRate();
			this.fwdXchgRate = builder.getFwdXchgRate();
			this.xchgRateBsis = ofNullable(builder.getXchgRateBsis()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("xchgRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xchgRate")
		public BigDecimal getXchgRate() {
			return xchgRate;
		}
		
		@Override
		@RosettaAttribute("fwdXchgRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fwdXchgRate")
		public BigDecimal getFwdXchgRate() {
			return fwdXchgRate;
		}
		
		@Override
		@RosettaAttribute("xchgRateBsis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xchgRateBsis")
		public ExchangeRateBasis1Choice__1 getXchgRateBsis() {
			return xchgRateBsis;
		}
		
		@Override
		public CurrencyExchange22__1 build() {
			return this;
		}
		
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder toBuilder() {
			CurrencyExchange22__1.CurrencyExchange22__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurrencyExchange22__1.CurrencyExchange22__1Builder builder) {
			ofNullable(getXchgRate()).ifPresent(builder::setXchgRate);
			ofNullable(getFwdXchgRate()).ifPresent(builder::setFwdXchgRate);
			ofNullable(getXchgRateBsis()).ifPresent(builder::setXchgRateBsis);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyExchange22__1 _that = getType().cast(o);
		
			if (!Objects.equals(xchgRate, _that.getXchgRate())) return false;
			if (!Objects.equals(fwdXchgRate, _that.getFwdXchgRate())) return false;
			if (!Objects.equals(xchgRateBsis, _that.getXchgRateBsis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (xchgRate != null ? xchgRate.hashCode() : 0);
			_result = 31 * _result + (fwdXchgRate != null ? fwdXchgRate.hashCode() : 0);
			_result = 31 * _result + (xchgRateBsis != null ? xchgRateBsis.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyExchange22__1 {" +
				"xchgRate=" + this.xchgRate + ", " +
				"fwdXchgRate=" + this.fwdXchgRate + ", " +
				"xchgRateBsis=" + this.xchgRateBsis +
			'}';
		}
	}

	/*********************** Builder Implementation of CurrencyExchange22__1  ***********************/
	class CurrencyExchange22__1BuilderImpl implements CurrencyExchange22__1.CurrencyExchange22__1Builder {
	
		protected BigDecimal xchgRate;
		protected BigDecimal fwdXchgRate;
		protected ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder xchgRateBsis;
		
		@Override
		@RosettaAttribute("xchgRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xchgRate")
		public BigDecimal getXchgRate() {
			return xchgRate;
		}
		
		@Override
		@RosettaAttribute("fwdXchgRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fwdXchgRate")
		public BigDecimal getFwdXchgRate() {
			return fwdXchgRate;
		}
		
		@Override
		@RosettaAttribute("xchgRateBsis")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("xchgRateBsis")
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder getXchgRateBsis() {
			return xchgRateBsis;
		}
		
		@Override
		public ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder getOrCreateXchgRateBsis() {
			ExchangeRateBasis1Choice__1.ExchangeRateBasis1Choice__1Builder result;
			if (xchgRateBsis!=null) {
				result = xchgRateBsis;
			}
			else {
				result = xchgRateBsis = ExchangeRateBasis1Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("xchgRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xchgRate")
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder setXchgRate(BigDecimal _xchgRate) {
			this.xchgRate = _xchgRate == null ? null : _xchgRate;
			return this;
		}
		
		@RosettaAttribute("fwdXchgRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fwdXchgRate")
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder setFwdXchgRate(BigDecimal _fwdXchgRate) {
			this.fwdXchgRate = _fwdXchgRate == null ? null : _fwdXchgRate;
			return this;
		}
		
		@RosettaAttribute("xchgRateBsis")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("xchgRateBsis")
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder setXchgRateBsis(ExchangeRateBasis1Choice__1 _xchgRateBsis) {
			this.xchgRateBsis = _xchgRateBsis == null ? null : _xchgRateBsis.toBuilder();
			return this;
		}
		
		@Override
		public CurrencyExchange22__1 build() {
			return new CurrencyExchange22__1.CurrencyExchange22__1Impl(this);
		}
		
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder prune() {
			if (xchgRateBsis!=null && !xchgRateBsis.prune().hasData()) xchgRateBsis = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getXchgRate()!=null) return true;
			if (getFwdXchgRate()!=null) return true;
			if (getXchgRateBsis()!=null && getXchgRateBsis().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyExchange22__1.CurrencyExchange22__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CurrencyExchange22__1.CurrencyExchange22__1Builder o = (CurrencyExchange22__1.CurrencyExchange22__1Builder) other;
			
			merger.mergeRosetta(getXchgRateBsis(), o.getXchgRateBsis(), this::setXchgRateBsis);
			
			merger.mergeBasic(getXchgRate(), o.getXchgRate(), this::setXchgRate);
			merger.mergeBasic(getFwdXchgRate(), o.getFwdXchgRate(), this::setFwdXchgRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyExchange22__1 _that = getType().cast(o);
		
			if (!Objects.equals(xchgRate, _that.getXchgRate())) return false;
			if (!Objects.equals(fwdXchgRate, _that.getFwdXchgRate())) return false;
			if (!Objects.equals(xchgRateBsis, _that.getXchgRateBsis())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (xchgRate != null ? xchgRate.hashCode() : 0);
			_result = 31 * _result + (fwdXchgRate != null ? fwdXchgRate.hashCode() : 0);
			_result = 31 * _result + (xchgRateBsis != null ? xchgRateBsis.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyExchange22__1Builder {" +
				"xchgRate=" + this.xchgRate + ", " +
				"fwdXchgRate=" + this.fwdXchgRate + ", " +
				"xchgRateBsis=" + this.xchgRateBsis +
			'}';
		}
	}
}
