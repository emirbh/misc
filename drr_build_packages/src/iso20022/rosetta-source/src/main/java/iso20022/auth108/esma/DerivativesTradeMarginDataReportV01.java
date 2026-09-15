package iso20022.auth108.esma;

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
import iso20022.auth108.esma.meta.DerivativesTradeMarginDataReportV01Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The DerivativesTradeMarginDataReport message is sent by the report submitting entity to the trade repository (TR) to report the margins exchanged in relation to the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativesTradeMarginDataReportV01", builder=DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativesTradeMarginDataReportV01", model="iso20022", builder=DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl.class, version="${project.version}")
public interface DerivativesTradeMarginDataReportV01 extends RosettaModelObject {

	DerivativesTradeMarginDataReportV01Meta metaData = new DerivativesTradeMarginDataReportV01Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Header information related to metadata of report message.
	 */
	TradeReportHeader4__1 getRptHdr();
	/**
	 * Set of data concerning the reporting trade.
	 */
	TradeData55Choice__1 getTradData();

	/*********************** Build Methods  ***********************/
	DerivativesTradeMarginDataReportV01 build();
	
	DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder();
	
	static DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder() {
		return new DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativesTradeMarginDataReportV01> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativesTradeMarginDataReportV01> getType() {
		return DerivativesTradeMarginDataReportV01.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4__1.class, getRptHdr());
		processRosetta(path.newSubPath("tradData"), processor, TradeData55Choice__1.class, getTradData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativesTradeMarginDataReportV01Builder extends DerivativesTradeMarginDataReportV01, RosettaModelObjectBuilder {
		TradeReportHeader4__1.TradeReportHeader4__1Builder getOrCreateRptHdr();
		@Override
		TradeReportHeader4__1.TradeReportHeader4__1Builder getRptHdr();
		TradeData55Choice__1.TradeData55Choice__1Builder getOrCreateTradData();
		@Override
		TradeData55Choice__1.TradeData55Choice__1Builder getTradData();
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setRptHdr(TradeReportHeader4__1 rptHdr);
		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setTradData(TradeData55Choice__1 tradData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4__1.TradeReportHeader4__1Builder.class, getRptHdr());
			processRosetta(path.newSubPath("tradData"), processor, TradeData55Choice__1.TradeData55Choice__1Builder.class, getTradData());
		}
		

		DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder prune();
	}

	/*********************** Immutable Implementation of DerivativesTradeMarginDataReportV01  ***********************/
	class DerivativesTradeMarginDataReportV01Impl implements DerivativesTradeMarginDataReportV01 {
		private final TradeReportHeader4__1 rptHdr;
		private final TradeData55Choice__1 tradData;
		
		protected DerivativesTradeMarginDataReportV01Impl(DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder) {
			this.rptHdr = ofNullable(builder.getRptHdr()).map(f->f.build()).orElse(null);
			this.tradData = ofNullable(builder.getTradData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptHdr")
		public TradeReportHeader4__1 getRptHdr() {
			return rptHdr;
		}
		
		@Override
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradData")
		public TradeData55Choice__1 getTradData() {
			return tradData;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01 build() {
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder() {
			DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder builder) {
			ofNullable(getRptHdr()).ifPresent(builder::setRptHdr);
			ofNullable(getTradData()).ifPresent(builder::setTradData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeMarginDataReportV01 _that = getType().cast(o);
		
			if (!Objects.equals(rptHdr, _that.getRptHdr())) return false;
			if (!Objects.equals(tradData, _that.getTradData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptHdr != null ? rptHdr.hashCode() : 0);
			_result = 31 * _result + (tradData != null ? tradData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativesTradeMarginDataReportV01 {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativesTradeMarginDataReportV01  ***********************/
	class DerivativesTradeMarginDataReportV01BuilderImpl implements DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder {
	
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr;
		protected TradeData55Choice__1.TradeData55Choice__1Builder tradData;
		
		@Override
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("rptHdr")
		public TradeReportHeader4__1.TradeReportHeader4__1Builder getRptHdr() {
			return rptHdr;
		}
		
		@Override
		public TradeReportHeader4__1.TradeReportHeader4__1Builder getOrCreateRptHdr() {
			TradeReportHeader4__1.TradeReportHeader4__1Builder result;
			if (rptHdr!=null) {
				result = rptHdr;
			}
			else {
				result = rptHdr = TradeReportHeader4__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tradData")
		public TradeData55Choice__1.TradeData55Choice__1Builder getTradData() {
			return tradData;
		}
		
		@Override
		public TradeData55Choice__1.TradeData55Choice__1Builder getOrCreateTradData() {
			TradeData55Choice__1.TradeData55Choice__1Builder result;
			if (tradData!=null) {
				result = tradData;
			}
			else {
				result = tradData = TradeData55Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptHdr")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setRptHdr(TradeReportHeader4__1 _rptHdr) {
			this.rptHdr = _rptHdr == null ? null : _rptHdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradData")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder setTradData(TradeData55Choice__1 _tradData) {
			this.tradData = _tradData == null ? null : _tradData.toBuilder();
			return this;
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01 build() {
			return new DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Impl(this);
		}
		
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder prune() {
			if (rptHdr!=null && !rptHdr.prune().hasData()) rptHdr = null;
			if (tradData!=null && !tradData.prune().hasData()) tradData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRptHdr()!=null && getRptHdr().hasData()) return true;
			if (getTradData()!=null && getTradData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder o = (DerivativesTradeMarginDataReportV01.DerivativesTradeMarginDataReportV01Builder) other;
			
			merger.mergeRosetta(getRptHdr(), o.getRptHdr(), this::setRptHdr);
			merger.mergeRosetta(getTradData(), o.getTradData(), this::setTradData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeMarginDataReportV01 _that = getType().cast(o);
		
			if (!Objects.equals(rptHdr, _that.getRptHdr())) return false;
			if (!Objects.equals(tradData, _that.getTradData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rptHdr != null ? rptHdr.hashCode() : 0);
			_result = 31 * _result + (tradData != null ? tradData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativesTradeMarginDataReportV01Builder {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData +
			'}';
		}
	}
}
