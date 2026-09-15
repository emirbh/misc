package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.CounterpartySpecificData36__2Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CounterpartySpecificData36__2", builder=CounterpartySpecificData36__2.CounterpartySpecificData36__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CounterpartySpecificData36__2", model="iso20022", builder=CounterpartySpecificData36__2.CounterpartySpecificData36__2BuilderImpl.class, version="${project.version}")
public interface CounterpartySpecificData36__2 extends RosettaModelObject {

	CounterpartySpecificData36__2Meta metaData = new CounterpartySpecificData36__2Meta();

	/*********************** Getter Methods  ***********************/
	TradeCounterpartyReport20__2 getCtrPty();
	ContractValuationData8__1 getValtn();
	ZonedDateTime getRptgTmStmp();

	/*********************** Build Methods  ***********************/
	CounterpartySpecificData36__2 build();
	
	CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder toBuilder();
	
	static CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder builder() {
		return new CounterpartySpecificData36__2.CounterpartySpecificData36__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CounterpartySpecificData36__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CounterpartySpecificData36__2> getType() {
		return CounterpartySpecificData36__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPty"), processor, TradeCounterpartyReport20__2.class, getCtrPty());
		processRosetta(path.newSubPath("valtn"), processor, ContractValuationData8__1.class, getValtn());
		processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface CounterpartySpecificData36__2Builder extends CounterpartySpecificData36__2, RosettaModelObjectBuilder {
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getOrCreateCtrPty();
		@Override
		TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder getCtrPty();
		ContractValuationData8__1.ContractValuationData8__1Builder getOrCreateValtn();
		@Override
		ContractValuationData8__1.ContractValuationData8__1Builder getValtn();
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setCtrPty(TradeCounterpartyReport20__2 ctrPty);
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setValtn(ContractValuationData8__1 valtn);
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setRptgTmStmp(ZonedDateTime rptgTmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPty"), processor, TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder.class, getCtrPty());
			processRosetta(path.newSubPath("valtn"), processor, ContractValuationData8__1.ContractValuationData8__1Builder.class, getValtn());
			processor.processBasic(path.newSubPath("rptgTmStmp"), ZonedDateTime.class, getRptgTmStmp(), this);
		}
		

		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder prune();
	}

	/*********************** Immutable Implementation of CounterpartySpecificData36__2  ***********************/
	class CounterpartySpecificData36__2Impl implements CounterpartySpecificData36__2 {
		private final TradeCounterpartyReport20__2 ctrPty;
		private final ContractValuationData8__1 valtn;
		private final ZonedDateTime rptgTmStmp;
		
		protected CounterpartySpecificData36__2Impl(CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder builder) {
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
		@Required
		@RuneAttribute("valtn")
		public ContractValuationData8__1 getValtn() {
			return valtn;
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@Override
		public CounterpartySpecificData36__2 build() {
			return this;
		}
		
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder toBuilder() {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder builder) {
			ofNullable(getCtrPty()).ifPresent(builder::setCtrPty);
			ofNullable(getValtn()).ifPresent(builder::setValtn);
			ofNullable(getRptgTmStmp()).ifPresent(builder::setRptgTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartySpecificData36__2 _that = getType().cast(o);
		
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
			return "CounterpartySpecificData36__2 {" +
				"ctrPty=" + this.ctrPty + ", " +
				"valtn=" + this.valtn + ", " +
				"rptgTmStmp=" + this.rptgTmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of CounterpartySpecificData36__2  ***********************/
	class CounterpartySpecificData36__2BuilderImpl implements CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder {
	
		protected TradeCounterpartyReport20__2.TradeCounterpartyReport20__2Builder ctrPty;
		protected ContractValuationData8__1.ContractValuationData8__1Builder valtn;
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
		@Required
		@RuneAttribute("valtn")
		public ContractValuationData8__1.ContractValuationData8__1Builder getValtn() {
			return valtn;
		}
		
		@Override
		public ContractValuationData8__1.ContractValuationData8__1Builder getOrCreateValtn() {
			ContractValuationData8__1.ContractValuationData8__1Builder result;
			if (valtn!=null) {
				result = valtn;
			}
			else {
				result = valtn = ContractValuationData8__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		public ZonedDateTime getRptgTmStmp() {
			return rptgTmStmp;
		}
		
		@RosettaAttribute("ctrPty")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPty")
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setCtrPty(TradeCounterpartyReport20__2 _ctrPty) {
			this.ctrPty = _ctrPty == null ? null : _ctrPty.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valtn")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("valtn")
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setValtn(ContractValuationData8__1 _valtn) {
			this.valtn = _valtn == null ? null : _valtn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rptgTmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptgTmStmp")
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder setRptgTmStmp(ZonedDateTime _rptgTmStmp) {
			this.rptgTmStmp = _rptgTmStmp == null ? null : _rptgTmStmp;
			return this;
		}
		
		@Override
		public CounterpartySpecificData36__2 build() {
			return new CounterpartySpecificData36__2.CounterpartySpecificData36__2Impl(this);
		}
		
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder prune() {
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
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder o = (CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder) other;
			
			merger.mergeRosetta(getCtrPty(), o.getCtrPty(), this::setCtrPty);
			merger.mergeRosetta(getValtn(), o.getValtn(), this::setValtn);
			
			merger.mergeBasic(getRptgTmStmp(), o.getRptgTmStmp(), this::setRptgTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CounterpartySpecificData36__2 _that = getType().cast(o);
		
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
			return "CounterpartySpecificData36__2Builder {" +
				"ctrPty=" + this.ctrPty + ", " +
				"valtn=" + this.valtn + ", " +
				"rptgTmStmp=" + this.rptgTmStmp +
			'}';
		}
	}
}
