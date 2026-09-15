package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.TradeData43__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData43__1", builder=TradeData43__1.TradeData43__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData43__1", model="iso20022", builder=TradeData43__1.TradeData43__1BuilderImpl.class, version="${project.version}")
public interface TradeData43__1 extends RosettaModelObject {

	TradeData43__1Meta metaData = new TradeData43__1Meta();

	/*********************** Getter Methods  ***********************/
	CounterpartySpecificData36__1 getCtrPtySpcfcData();
	CommonTradeDataReport71__1 getCmonTradData();
	TechnicalAttributes5__1 getTechAttrbts();

	/*********************** Build Methods  ***********************/
	TradeData43__1 build();
	
	TradeData43__1.TradeData43__1Builder toBuilder();
	
	static TradeData43__1.TradeData43__1Builder builder() {
		return new TradeData43__1.TradeData43__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData43__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData43__1> getType() {
		return TradeData43__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__1.class, getCtrPtySpcfcData());
		processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__1.class, getCmonTradData());
		processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.class, getTechAttrbts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData43__1Builder extends TradeData43__1, RosettaModelObjectBuilder {
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getOrCreateCtrPtySpcfcData();
		@Override
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getCtrPtySpcfcData();
		CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder getOrCreateCmonTradData();
		@Override
		CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder getCmonTradData();
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getOrCreateTechAttrbts();
		@Override
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getTechAttrbts();
		TradeData43__1.TradeData43__1Builder setCtrPtySpcfcData(CounterpartySpecificData36__1 ctrPtySpcfcData);
		TradeData43__1.TradeData43__1Builder setCmonTradData(CommonTradeDataReport71__1 cmonTradData);
		TradeData43__1.TradeData43__1Builder setTechAttrbts(TechnicalAttributes5__1 techAttrbts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder.class, getCtrPtySpcfcData());
			processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder.class, getCmonTradData());
			processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.TechnicalAttributes5__1Builder.class, getTechAttrbts());
		}
		

		TradeData43__1.TradeData43__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeData43__1  ***********************/
	class TradeData43__1Impl implements TradeData43__1 {
		private final CounterpartySpecificData36__1 ctrPtySpcfcData;
		private final CommonTradeDataReport71__1 cmonTradData;
		private final TechnicalAttributes5__1 techAttrbts;
		
		protected TradeData43__1Impl(TradeData43__1.TradeData43__1Builder builder) {
			this.ctrPtySpcfcData = ofNullable(builder.getCtrPtySpcfcData()).map(f->f.build()).orElse(null);
			this.cmonTradData = ofNullable(builder.getCmonTradData()).map(f->f.build()).orElse(null);
			this.techAttrbts = ofNullable(builder.getTechAttrbts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__1 getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport71__1 getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes5__1 getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		public TradeData43__1 build() {
			return this;
		}
		
		@Override
		public TradeData43__1.TradeData43__1Builder toBuilder() {
			TradeData43__1.TradeData43__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData43__1.TradeData43__1Builder builder) {
			ofNullable(getCtrPtySpcfcData()).ifPresent(builder::setCtrPtySpcfcData);
			ofNullable(getCmonTradData()).ifPresent(builder::setCmonTradData);
			ofNullable(getTechAttrbts()).ifPresent(builder::setTechAttrbts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData43__1 {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData43__1  ***********************/
	class TradeData43__1BuilderImpl implements TradeData43__1.TradeData43__1Builder {
	
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData;
		protected CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder cmonTradData;
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts;
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		public CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getOrCreateCtrPtySpcfcData() {
			CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder result;
			if (ctrPtySpcfcData!=null) {
				result = ctrPtySpcfcData;
			}
			else {
				result = ctrPtySpcfcData = CounterpartySpecificData36__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		public CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder getOrCreateCmonTradData() {
			CommonTradeDataReport71__1.CommonTradeDataReport71__1Builder result;
			if (cmonTradData!=null) {
				result = cmonTradData;
			}
			else {
				result = cmonTradData = CommonTradeDataReport71__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techAttrbts")
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder getTechAttrbts() {
			return techAttrbts;
		}
		
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder getOrCreateTechAttrbts() {
			TechnicalAttributes5__1.TechnicalAttributes5__1Builder result;
			if (techAttrbts!=null) {
				result = techAttrbts;
			}
			else {
				result = techAttrbts = TechnicalAttributes5__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		@Override
		public TradeData43__1.TradeData43__1Builder setCtrPtySpcfcData(CounterpartySpecificData36__1 _ctrPtySpcfcData) {
			this.ctrPtySpcfcData = _ctrPtySpcfcData == null ? null : _ctrPtySpcfcData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cmonTradData")
		@Override
		public TradeData43__1.TradeData43__1Builder setCmonTradData(CommonTradeDataReport71__1 _cmonTradData) {
			this.cmonTradData = _cmonTradData == null ? null : _cmonTradData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techAttrbts")
		@Override
		public TradeData43__1.TradeData43__1Builder setTechAttrbts(TechnicalAttributes5__1 _techAttrbts) {
			this.techAttrbts = _techAttrbts == null ? null : _techAttrbts.toBuilder();
			return this;
		}
		
		@Override
		public TradeData43__1 build() {
			return new TradeData43__1.TradeData43__1Impl(this);
		}
		
		@Override
		public TradeData43__1.TradeData43__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData43__1.TradeData43__1Builder prune() {
			if (ctrPtySpcfcData!=null && !ctrPtySpcfcData.prune().hasData()) ctrPtySpcfcData = null;
			if (cmonTradData!=null && !cmonTradData.prune().hasData()) cmonTradData = null;
			if (techAttrbts!=null && !techAttrbts.prune().hasData()) techAttrbts = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrPtySpcfcData()!=null && getCtrPtySpcfcData().hasData()) return true;
			if (getCmonTradData()!=null && getCmonTradData().hasData()) return true;
			if (getTechAttrbts()!=null && getTechAttrbts().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData43__1.TradeData43__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData43__1.TradeData43__1Builder o = (TradeData43__1.TradeData43__1Builder) other;
			
			merger.mergeRosetta(getCtrPtySpcfcData(), o.getCtrPtySpcfcData(), this::setCtrPtySpcfcData);
			merger.mergeRosetta(getCmonTradData(), o.getCmonTradData(), this::setCmonTradData);
			merger.mergeRosetta(getTechAttrbts(), o.getTechAttrbts(), this::setTechAttrbts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__1 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData43__1Builder {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}
}
