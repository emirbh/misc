package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.TradeData43__3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details of a new trade transaction report.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeData43__3", builder=TradeData43__3.TradeData43__3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeData43__3", model="iso20022", builder=TradeData43__3.TradeData43__3BuilderImpl.class, version="${project.version}")
public interface TradeData43__3 extends RosettaModelObject {

	TradeData43__3Meta metaData = new TradeData43__3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data specific to counterparties and related fields.
	 */
	CounterpartySpecificData36__1 getCtrPtySpcfcData();
	/**
	 * Data specifically related to transaction.
	 */
	CommonTradeDataReport71__3 getCmonTradData();
	/**
	 * Specifies technical attributes of the message.
	 */
	TechnicalAttributes5__1 getTechAttrbts();
	/**
	 * Additional information that can not be captured in the structured fields and/or any other specific block.
	 */
	SupplementaryData1 getSplmtryData();

	/*********************** Build Methods  ***********************/
	TradeData43__3 build();
	
	TradeData43__3.TradeData43__3Builder toBuilder();
	
	static TradeData43__3.TradeData43__3Builder builder() {
		return new TradeData43__3.TradeData43__3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeData43__3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeData43__3> getType() {
		return TradeData43__3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__1.class, getCtrPtySpcfcData());
		processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__3.class, getCmonTradData());
		processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.class, getTechAttrbts());
		processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.class, getSplmtryData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeData43__3Builder extends TradeData43__3, RosettaModelObjectBuilder {
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getOrCreateCtrPtySpcfcData();
		@Override
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder getCtrPtySpcfcData();
		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder getOrCreateCmonTradData();
		@Override
		CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder getCmonTradData();
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getOrCreateTechAttrbts();
		@Override
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder getTechAttrbts();
		SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData();
		@Override
		SupplementaryData1.SupplementaryData1Builder getSplmtryData();
		TradeData43__3.TradeData43__3Builder setCtrPtySpcfcData(CounterpartySpecificData36__1 ctrPtySpcfcData);
		TradeData43__3.TradeData43__3Builder setCmonTradData(CommonTradeDataReport71__3 cmonTradData);
		TradeData43__3.TradeData43__3Builder setTechAttrbts(TechnicalAttributes5__1 techAttrbts);
		TradeData43__3.TradeData43__3Builder setSplmtryData(SupplementaryData1 splmtryData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrPtySpcfcData"), processor, CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder.class, getCtrPtySpcfcData());
			processRosetta(path.newSubPath("cmonTradData"), processor, CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder.class, getCmonTradData());
			processRosetta(path.newSubPath("techAttrbts"), processor, TechnicalAttributes5__1.TechnicalAttributes5__1Builder.class, getTechAttrbts());
			processRosetta(path.newSubPath("splmtryData"), processor, SupplementaryData1.SupplementaryData1Builder.class, getSplmtryData());
		}
		

		TradeData43__3.TradeData43__3Builder prune();
	}

	/*********************** Immutable Implementation of TradeData43__3  ***********************/
	class TradeData43__3Impl implements TradeData43__3 {
		private final CounterpartySpecificData36__1 ctrPtySpcfcData;
		private final CommonTradeDataReport71__3 cmonTradData;
		private final TechnicalAttributes5__1 techAttrbts;
		private final SupplementaryData1 splmtryData;
		
		protected TradeData43__3Impl(TradeData43__3.TradeData43__3Builder builder) {
			this.ctrPtySpcfcData = ofNullable(builder.getCtrPtySpcfcData()).map(f->f.build()).orElse(null);
			this.cmonTradData = ofNullable(builder.getCmonTradData()).map(f->f.build()).orElse(null);
			this.techAttrbts = ofNullable(builder.getTechAttrbts()).map(f->f.build()).orElse(null);
			this.splmtryData = ofNullable(builder.getSplmtryData()).map(f->f.build()).orElse(null);
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
		public CommonTradeDataReport71__3 getCmonTradData() {
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
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("splmtryData")
		public SupplementaryData1 getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public TradeData43__3 build() {
			return this;
		}
		
		@Override
		public TradeData43__3.TradeData43__3Builder toBuilder() {
			TradeData43__3.TradeData43__3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeData43__3.TradeData43__3Builder builder) {
			ofNullable(getCtrPtySpcfcData()).ifPresent(builder::setCtrPtySpcfcData);
			ofNullable(getCmonTradData()).ifPresent(builder::setCmonTradData);
			ofNullable(getTechAttrbts()).ifPresent(builder::setTechAttrbts);
			ofNullable(getSplmtryData()).ifPresent(builder::setSplmtryData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			if (!Objects.equals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData43__3 {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeData43__3  ***********************/
	class TradeData43__3BuilderImpl implements TradeData43__3.TradeData43__3Builder {
	
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData;
		protected CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder cmonTradData;
		protected TechnicalAttributes5__1.TechnicalAttributes5__1Builder techAttrbts;
		protected SupplementaryData1.SupplementaryData1Builder splmtryData;
		
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
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder getCmonTradData() {
			return cmonTradData;
		}
		
		@Override
		public CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder getOrCreateCmonTradData() {
			CommonTradeDataReport71__3.CommonTradeDataReport71__3Builder result;
			if (cmonTradData!=null) {
				result = cmonTradData;
			}
			else {
				result = cmonTradData = CommonTradeDataReport71__3.builder();
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
		
		@Override
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("splmtryData")
		public SupplementaryData1.SupplementaryData1Builder getSplmtryData() {
			return splmtryData;
		}
		
		@Override
		public SupplementaryData1.SupplementaryData1Builder getOrCreateSplmtryData() {
			SupplementaryData1.SupplementaryData1Builder result;
			if (splmtryData!=null) {
				result = splmtryData;
			}
			else {
				result = splmtryData = SupplementaryData1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrPtySpcfcData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrPtySpcfcData")
		@Override
		public TradeData43__3.TradeData43__3Builder setCtrPtySpcfcData(CounterpartySpecificData36__1 _ctrPtySpcfcData) {
			this.ctrPtySpcfcData = _ctrPtySpcfcData == null ? null : _ctrPtySpcfcData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cmonTradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cmonTradData")
		@Override
		public TradeData43__3.TradeData43__3Builder setCmonTradData(CommonTradeDataReport71__3 _cmonTradData) {
			this.cmonTradData = _cmonTradData == null ? null : _cmonTradData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("techAttrbts")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techAttrbts")
		@Override
		public TradeData43__3.TradeData43__3Builder setTechAttrbts(TechnicalAttributes5__1 _techAttrbts) {
			this.techAttrbts = _techAttrbts == null ? null : _techAttrbts.toBuilder();
			return this;
		}
		
		@RosettaAttribute("splmtryData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("splmtryData")
		@Override
		public TradeData43__3.TradeData43__3Builder setSplmtryData(SupplementaryData1 _splmtryData) {
			this.splmtryData = _splmtryData == null ? null : _splmtryData.toBuilder();
			return this;
		}
		
		@Override
		public TradeData43__3 build() {
			return new TradeData43__3.TradeData43__3Impl(this);
		}
		
		@Override
		public TradeData43__3.TradeData43__3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData43__3.TradeData43__3Builder prune() {
			if (ctrPtySpcfcData!=null && !ctrPtySpcfcData.prune().hasData()) ctrPtySpcfcData = null;
			if (cmonTradData!=null && !cmonTradData.prune().hasData()) cmonTradData = null;
			if (techAttrbts!=null && !techAttrbts.prune().hasData()) techAttrbts = null;
			if (splmtryData!=null && !splmtryData.prune().hasData()) splmtryData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrPtySpcfcData()!=null && getCtrPtySpcfcData().hasData()) return true;
			if (getCmonTradData()!=null && getCmonTradData().hasData()) return true;
			if (getTechAttrbts()!=null && getTechAttrbts().hasData()) return true;
			if (getSplmtryData()!=null && getSplmtryData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeData43__3.TradeData43__3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeData43__3.TradeData43__3Builder o = (TradeData43__3.TradeData43__3Builder) other;
			
			merger.mergeRosetta(getCtrPtySpcfcData(), o.getCtrPtySpcfcData(), this::setCtrPtySpcfcData);
			merger.mergeRosetta(getCmonTradData(), o.getCmonTradData(), this::setCmonTradData);
			merger.mergeRosetta(getTechAttrbts(), o.getTechAttrbts(), this::setTechAttrbts);
			merger.mergeRosetta(getSplmtryData(), o.getSplmtryData(), this::setSplmtryData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeData43__3 _that = getType().cast(o);
		
			if (!Objects.equals(ctrPtySpcfcData, _that.getCtrPtySpcfcData())) return false;
			if (!Objects.equals(cmonTradData, _that.getCmonTradData())) return false;
			if (!Objects.equals(techAttrbts, _that.getTechAttrbts())) return false;
			if (!Objects.equals(splmtryData, _that.getSplmtryData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrPtySpcfcData != null ? ctrPtySpcfcData.hashCode() : 0);
			_result = 31 * _result + (cmonTradData != null ? cmonTradData.hashCode() : 0);
			_result = 31 * _result + (techAttrbts != null ? techAttrbts.hashCode() : 0);
			_result = 31 * _result + (splmtryData != null ? splmtryData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeData43__3Builder {" +
				"ctrPtySpcfcData=" + this.ctrPtySpcfcData + ", " +
				"cmonTradData=" + this.cmonTradData + ", " +
				"techAttrbts=" + this.techAttrbts + ", " +
				"splmtryData=" + this.splmtryData +
			'}';
		}
	}
}
