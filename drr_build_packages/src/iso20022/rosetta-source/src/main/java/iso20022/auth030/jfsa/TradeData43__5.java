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
import iso20022.auth030.jfsa.meta.TradeData43__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData43__5", builder=TradeData43__5.TradeData43__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData43__5", model="iso20022", builder=TradeData43__5.TradeData43__5BuilderImpl.class, version="${project.version}")
public interface TradeData43__5 extends RosettaModelObject {

	TradeData43__5Meta metaData = new TradeData43__5Meta();

	/*********************** Getter Methods  ***********************/
	CounterpartySpecificData36__2 getCtrPtySpcfcData();
	CommonTradeDataReport71__5 getCmonTradData();
	TechnicalAttributes5__1 getTechAttrbts();

	/*********************** Build Methods  ***********************/
	TradeData43__5 build();
	
	TradeData43__5.TradeData43__5Builder toBuilder();
	
	static TradeData43__5.TradeData43__5Builder builder() {
		return new TradeData43__5.TradeData43__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData43__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData43__5> getType() {
		return TradeData43__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__2.class, getCtrPtySpcfcData());
		processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__5.class, getCmonTradData());
		processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.class, getTechAttrbts());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData43__5Builder extends TradeData43__5, RosettaModelObjectBuilder {
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getOrCreateCtrPtySpcfcData();
		@Override
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getCtrPtySpcfcData();
		CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder getOrCreateCmonTradData();
		@Override
		CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder getCmonTradData();
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getOrCreateTechAttrbts();
		@Override
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getTechAttrbts();
		TradeData43__5.TradeData43__5Builder setCtrPtySpcfcData(CounterpartySpecificData36__2 ctrPtySpcfcData);
		TradeData43__5.TradeData43__5Builder setCmonTradData(CommonTradeDataReport71__5 cmonTradData);
		TradeData43__5.TradeData43__5Builder setTechAttrbts(TechnicalAttributes5__1 techAttrbts);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder.class, getCtrPtySpcfcData());
			processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder.class, getCmonTradData());
			processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.TechnicalAttributes5__1Builder.class, getTechAttrbts());
		}
		

		TradeData43__5.TradeData43__5Builder prune();
	}

	/*********************** Immutable Implementation of TradeData43__5  ***********************/
	class TradeData43__5Impl implements TradeData43__5 {
		private final CounterpartySpecificData36__2 ctrPtySpcfcData;
		private final CommonTradeDataReport71__5 cmonTradData;
		private final TechnicalAttributes5__1 techAttrbts;
		
		protected TradeData43__5Impl(TradeData43__5.TradeData43__5Builder builder) {
			this.ctrPtySpcfcData = ofNullable(builder.getCtrPtySpcfcData()).map(f->f.build()).orElse(null);
			this.cmonTradData = ofNullable(builder.getCmonTradData()).map(f->f.build()).orElse(null);
			this.techAttrbts = ofNullable(builder.getTechAttrbts()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__2 getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport71__5 getCmonTradData() {
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
		public TradeData43__5 build() {
			return this;
		}
		
		@Override
		public TradeData43__5.TradeData43__5Builder toBuilder() {
			TradeData43__5.TradeData43__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData43__5.TradeData43__5Builder builder) {
			ofNullable(getCtrPtySpcfcData()).ifPresent(builder::setCtrPtySpcfcData);
			ofNullable(getCmonTradData()).ifPresent(builder::setCmonTradData);
			ofNullable(getTechAttrbts()).ifPresent(builder::setTechAttrbts);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__5 _that = getType().cast(o);
		
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
			return "TradeData43__5 {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData43__5  ***********************/
	class TradeData43__5BuilderImpl implements TradeData43__5.TradeData43__5Builder {
	
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData;
		protected CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder cmonTradData;
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts;
		
		@Override
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getCtrPtySpcfcData() {
			return ctrPtySpcfcData;
		}
		
		@Override
		public CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder getOrCreateCtrPtySpcfcData() {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder result;
			if (ctrPtySpcfcData!=null) {
				result = ctrPtySpcfcData;
			}
			else {
				result = ctrPtySpcfcData = CounterpartySpecificData36__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cmonTradData")
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder getOrCreateCmonTradData() {
			CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder result;
			if (cmonTradData!=null) {
				result = cmonTradData;
			}
			else {
				result = cmonTradData = CommonTradeDataReport71__5.builder();
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
		public TradeData43__5.TradeData43__5Builder setCtrPtySpcfcData(CounterpartySpecificData36__2 _ctrPtySpcfcData) {
			this.ctrPtySpcfcData = _ctrPtySpcfcData == null ? null : _ctrPtySpcfcData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cmonTradData")
		@Override
		public TradeData43__5.TradeData43__5Builder setCmonTradData(CommonTradeDataReport71__5 _cmonTradData) {
			this.cmonTradData = _cmonTradData == null ? null : _cmonTradData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techAttrbts")
		@Override
		public TradeData43__5.TradeData43__5Builder setTechAttrbts(TechnicalAttributes5__1 _techAttrbts) {
			this.techAttrbts = _techAttrbts == null ? null : _techAttrbts.toBuilder();
			return this;
		}
		
		@Override
		public TradeData43__5 build() {
			return new TradeData43__5.TradeData43__5Impl(this);
		}
		
		@Override
		public TradeData43__5.TradeData43__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData43__5.TradeData43__5Builder prune() {
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
		public TradeData43__5.TradeData43__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData43__5.TradeData43__5Builder o = (TradeData43__5.TradeData43__5Builder) other;
			
			merger.mergeRosetta(getCtrPtySpcfcData(), o.getCtrPtySpcfcData(), this::setCtrPtySpcfcData);
			merger.mergeRosetta(getCmonTradData(), o.getCmonTradData(), this::setCmonTradData);
			merger.mergeRosetta(getTechAttrbts(), o.getTechAttrbts(), this::setTechAttrbts);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__5 _that = getType().cast(o);
		
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
			return "TradeData43__5Builder {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts +
			'}';
		}
	}
}
