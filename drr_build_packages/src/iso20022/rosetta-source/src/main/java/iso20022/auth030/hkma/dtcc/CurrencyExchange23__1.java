package iso20022.auth030.hkma.dtcc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import iso20022.auth030.hkma.dtcc.meta.CurrencyExchange23__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the details of the currency exchange.
 * @version ${project.version}
 */
@RosettaDataType(value="CurrencyExchange23__1", builder=CurrencyExchange23__1.CurrencyExchange23__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CurrencyExchange23__1", model="iso20022", builder=CurrencyExchange23__1.CurrencyExchange23__1BuilderImpl.class, version="${project.version}")
public interface CurrencyExchange23__1 extends RosettaModelObject {

	CurrencyExchange23__1Meta metaData = new CurrencyExchange23__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the currency.
	 */
	String getCcy();
	/**
	 * Specifies the date when a derivative will fix against an interest rate or an exchange rate that will be used to compute the cash settlement.
	 */
	ZonedDateTime getFxgDt();

	/*********************** Build Methods  ***********************/
	CurrencyExchange23__1 build();
	
	CurrencyExchange23__1.CurrencyExchange23__1Builder toBuilder();
	
	static CurrencyExchange23__1.CurrencyExchange23__1Builder builder() {
		return new CurrencyExchange23__1.CurrencyExchange23__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CurrencyExchange23__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CurrencyExchange23__1> getType() {
		return CurrencyExchange23__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
		processor.processBasic(path.newSubPath("fxgDt"), ZonedDateTime.class, getFxgDt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CurrencyExchange23__1Builder extends CurrencyExchange23__1, RosettaModelObjectBuilder {
		CurrencyExchange23__1.CurrencyExchange23__1Builder setCcy(String ccy);
		CurrencyExchange23__1.CurrencyExchange23__1Builder setFxgDt(ZonedDateTime fxgDt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ccy"), String.class, getCcy(), this);
			processor.processBasic(path.newSubPath("fxgDt"), ZonedDateTime.class, getFxgDt(), this);
		}
		

		CurrencyExchange23__1.CurrencyExchange23__1Builder prune();
	}

	/*********************** Immutable Implementation of CurrencyExchange23__1  ***********************/
	class CurrencyExchange23__1Impl implements CurrencyExchange23__1 {
		private final String ccy;
		private final ZonedDateTime fxgDt;
		
		protected CurrencyExchange23__1Impl(CurrencyExchange23__1.CurrencyExchange23__1Builder builder) {
			this.ccy = builder.getCcy();
			this.fxgDt = builder.getFxgDt();
		}
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@Override
		@RosettaAttribute("fxgDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxgDt")
		public ZonedDateTime getFxgDt() {
			return fxgDt;
		}
		
		@Override
		public CurrencyExchange23__1 build() {
			return this;
		}
		
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder toBuilder() {
			CurrencyExchange23__1.CurrencyExchange23__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CurrencyExchange23__1.CurrencyExchange23__1Builder builder) {
			ofNullable(getCcy()).ifPresent(builder::setCcy);
			ofNullable(getFxgDt()).ifPresent(builder::setFxgDt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyExchange23__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(fxgDt, _that.getFxgDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (fxgDt != null ? fxgDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyExchange23__1 {" +
				"ccy=" + this.ccy + ", " +
				"fxgDt=" + this.fxgDt +
			'}';
		}
	}

	/*********************** Builder Implementation of CurrencyExchange23__1  ***********************/
	class CurrencyExchange23__1BuilderImpl implements CurrencyExchange23__1.CurrencyExchange23__1Builder {
	
		protected String ccy;
		protected ZonedDateTime fxgDt;
		
		@Override
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ccy")
		public String getCcy() {
			return ccy;
		}
		
		@Override
		@RosettaAttribute("fxgDt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fxgDt")
		public ZonedDateTime getFxgDt() {
			return fxgDt;
		}
		
		@RosettaAttribute("ccy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ccy")
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder setCcy(String _ccy) {
			this.ccy = _ccy == null ? null : _ccy;
			return this;
		}
		
		@RosettaAttribute("fxgDt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fxgDt")
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder setFxgDt(ZonedDateTime _fxgDt) {
			this.fxgDt = _fxgDt == null ? null : _fxgDt;
			return this;
		}
		
		@Override
		public CurrencyExchange23__1 build() {
			return new CurrencyExchange23__1.CurrencyExchange23__1Impl(this);
		}
		
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCcy()!=null) return true;
			if (getFxgDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CurrencyExchange23__1.CurrencyExchange23__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CurrencyExchange23__1.CurrencyExchange23__1Builder o = (CurrencyExchange23__1.CurrencyExchange23__1Builder) other;
			
			
			merger.mergeBasic(getCcy(), o.getCcy(), this::setCcy);
			merger.mergeBasic(getFxgDt(), o.getFxgDt(), this::setFxgDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CurrencyExchange23__1 _that = getType().cast(o);
		
			if (!Objects.equals(ccy, _that.getCcy())) return false;
			if (!Objects.equals(fxgDt, _that.getFxgDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ccy != null ? ccy.hashCode() : 0);
			_result = 31 * _result + (fxgDt != null ? fxgDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CurrencyExchange23__1Builder {" +
				"ccy=" + this.ccy + ", " +
				"fxgDt=" + this.fxgDt +
			'}';
		}
	}
}
