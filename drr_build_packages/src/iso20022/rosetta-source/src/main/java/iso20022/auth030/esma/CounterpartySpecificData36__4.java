package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.CounterpartySpecificData36__4Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Data related specifically to counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="CounterpartySpecificData36__4", builder=CounterpartySpecificData36__4.CounterpartySpecificData36__4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CounterpartySpecificData36__4", model="iso20022", builder=CounterpartySpecificData36__4.CounterpartySpecificData36__4BuilderImpl.class, version="${project.version}")
public interface CounterpartySpecificData36__4 extends RosettaModelObject {

	CounterpartySpecificData36__4Meta metaData = new CounterpartySpecificData36__4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data specific to counterparties of the reported transaction/position.
	 */
	TradeCounterpartyReport20__2 getCtrPty();
	/**
	 * Data specific to the valuation of the transaction.
	 */
	ContractValuationData8__2 getValtn();
	/**
	 * Indicates the date and time of the submission of the report to the trade repository.
	 */
	ZonedDateTime getRptgTmStmp();

	/*********************** Build Methods  ***********************/
	CounterpartySpecificData36__4 build();
	
	CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder toBuilder();
	
	static CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder builder() {
		return new CounterpartySpecificData36__4.CounterpartySpecificData36__4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartySpecificData36__4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartySpecificData36__4> getType() {
		return CounterpartySpecificData36__4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPty"), processor, TradeCounterpartyReport20__2.class, getCtrPty());
		processRosetta(path.newSubPath("valtn"), processor, ContractValuationData8__2.class, getValtn());
		processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartySpecificData36__4Builder extends CounterpartySpecificData36__4, RosettaModelObjectBuilder {
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getOrCreateCtrPty();
		@Override
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getCtrPty();
		ContractValuationData8__2.ContractValuationData8__2Builder getOrCreateValtn();
		@Override
		ContractValuationData8__2.ContractValuationData8__2Builder getValtn();
		CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setCtrPty(TradeCounterpartyReport20__2 ctrPty);
		CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setValtn(ContractValuationData8__2 valtn);
		CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setRptgTmStmp(ZonedDateTime rptgTmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPty"), processor, TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder.class, getCtrPty());
			processRosetta(path.newSubPath("valtn"), processor, ContractValuationData8__2.ContractValuationData8__2Builder.class, getValtn());
			processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
		}
		

		CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder prune();
	}

	/*********************** Immutable Implementation of CounterpartySpecificData36__4  ***********************/
	class CounterpartySpecificData36__4Impl implements CounterpartySpecificData36__4 {
		private final TradeCounterpartyReport20__2 ctrPty;
		private final ContractValuationData8__2 valtn;
		private final ZonedDateTime rptgTmStmp;
		
		protected CounterpartySpecificData36__4Impl(CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder builder) {
			this.ctrPty = ofNullable(builder.getCtrPty()).map(f->f.build()).orElse(null);
			this.valtn = ofNullable(builder.getValtn()).map(f->f.build()).orElse(null);
			this.rptgTmStmp = builder.getRptgTmStmp();
		}
		
		@Override
		@RosettaAttribute("ctrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPty")
		public TradeCounterpartyReport20__2 getCtrPty() {
			return ctrPty;
		}
		
		@Override
		@RosettaAttribute("valtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtn")
		public ContractValuationData8__2 getValtn() {
			return valtn;
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		public CounterpartySpecificData36__4 build() {
			return this;
		}
		
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder toBuilder() {
			CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder builder) {
			ofNullable(getCtrPty()).ifPresent(builder::setCtrPty);
			ofNullable(getValtn()).ifPresent(builder::setValtn);
			ofNullable(getRptgTmStmp()).ifPresent(builder::setRptgTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartySpecificData36__4 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPty, _that.getCtrPty())) return false;
			if (!Objects.equals(valtn, _that.getValtn())) return false;
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPty != null ? ctrPty.hashCode() : 0);
			_result = 31 * _result + (valtn != null ? valtn.hashCode() : 0);
			_result = 31 * _result + (rptgTmStmp != null ? rptgTmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartySpecificData36__4 {" +
				"ctrPty=" + this.ctrPty + ", " +
				"valtn=" + this.valtn + ", " +
				"rptgTmStmp=" + this.rptgTmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartySpecificData36__4  ***********************/
	class CounterpartySpecificData36__4BuilderImpl implements CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder {
	
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty;
		protected ContractValuationData8__2.ContractValuationData8__2Builder valtn;
		protected ZonedDateTime rptgTmStmp;
		
		@Override
		@RosettaAttribute("ctrPty")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPty")
		public TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getCtrPty() {
			return ctrPty;
		}
		
		@Override
		public TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getOrCreateCtrPty() {
			TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder result;
			if (ctrPty!=null) {
				result = ctrPty;
			}
			else {
				result = ctrPty = TradeCounterpartyReport20__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valtn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtn")
		public ContractValuationData8__2.ContractValuationData8__2Builder getValtn() {
			return valtn;
		}
		
		@Override
		public ContractValuationData8__2.ContractValuationData8__2Builder getOrCreateValtn() {
			ContractValuationData8__2.ContractValuationData8__2Builder result;
			if (valtn!=null) {
				result = valtn;
			}
			else {
				result = valtn = ContractValuationData8__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@RosettaAttribute("ctrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPty")
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setCtrPty(TradeCounterpartyReport20__2 _ctrPty) {
			this.ctrPty = _ctrPty == null ? null : _ctrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valtn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valtn")
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setValtn(ContractValuationData8__2 _valtn) {
			this.valtn = _valtn == null ? null : _valtn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptgTmStmp")
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder setRptgTmStmp(ZonedDateTime _rptgTmStmp) {
			this.rptgTmStmp = _rptgTmStmp == null ? null : _rptgTmStmp;
			return this;
		}
		
		@Override
		public CounterpartySpecificData36__4 build() {
			return new CounterpartySpecificData36__4.CounterpartySpecificData36__4Impl(this);
		}
		
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder prune() {
			if (ctrPty!=null && !ctrPty.prune().hasData()) ctrPty = null;
			if (valtn!=null && !valtn.prune().hasData()) valtn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrPty()!=null && getCtrPty().hasData()) return true;
			if (getValtn()!=null && getValtn().hasData()) return true;
			if (getRptgTmStmp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder o = (CounterpartySpecificData36__4.CounterpartySpecificData36__4Builder) other;
			
			merger.mergeRosetta(getCtrPty(), o.getCtrPty(), this::setCtrPty);
			merger.mergeRosetta(getValtn(), o.getValtn(), this::setValtn);
			
			merger.mergeBasic(getRptgTmStmp(), o.getRptgTmStmp(), this::setRptgTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartySpecificData36__4 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPty, _that.getCtrPty())) return false;
			if (!Objects.equals(valtn, _that.getValtn())) return false;
			if (!Objects.equals(rptgTmStmp, _that.getRptgTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPty != null ? ctrPty.hashCode() : 0);
			_result = 31 * _result + (valtn != null ? valtn.hashCode() : 0);
			_result = 31 * _result + (rptgTmStmp != null ? rptgTmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CounterpartySpecificData36__4Builder {" +
				"ctrPty=" + this.ctrPty + ", " +
				"valtn=" + this.valtn + ", " +
				"rptgTmStmp=" + this.rptgTmStmp +
			'}';
		}
	}
}
