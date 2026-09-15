package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.DerivativesTradeReportV03Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The DerivativesTradeReport message is sent by the report submitting entity to the trade repository (TR) to report on the derivative transactions or sent by the trade repository (TR) to the authority or made available by the trade repository (TR) to the report submitting entity and the reporting counterparty as well as the entity responsible for reporting, if applicable.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativesTradeReportV03", builder=DerivativesTradeReportV03.DerivativesTradeReportV03BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativesTradeReportV03", model="iso20022", builder=DerivativesTradeReportV03.DerivativesTradeReportV03BuilderImpl.class, version="${project.version}")
public interface DerivativesTradeReportV03 extends RosettaModelObject {

	DerivativesTradeReportV03Meta metaData = new DerivativesTradeReportV03Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Header information related to metadata of report message.
	 */
	TradeReportHeader4__1 getRptHdr();
	/**
	 * Data concerning the reporting trade.
	 */
	TradeData57Choice__1 getTradData();

	/*********************** Build Methods  ***********************/
	DerivativesTradeReportV03 build();
	
	DerivativesTradeReportV03.DerivativesTradeReportV03Builder toBuilder();
	
	static DerivativesTradeReportV03.DerivativesTradeReportV03Builder builder() {
		return new DerivativesTradeReportV03.DerivativesTradeReportV03BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativesTradeReportV03> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativesTradeReportV03> getType() {
		return DerivativesTradeReportV03.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4__1.class, getRptHdr());
		processRosetta(path.newSubPath("tradData"), processor, TradeData57Choice__1.class, getTradData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativesTradeReportV03Builder extends DerivativesTradeReportV03, RosettaModelObjectBuilder {
		TradeReportHeader4__1.TradeReportHeader4__1Builder getOrCreateRptHdr();
		@Override
		TradeReportHeader4__1.TradeReportHeader4__1Builder getRptHdr();
		TradeData57Choice__1.TradeData57Choice__1Builder getOrCreateTradData();
		@Override
		TradeData57Choice__1.TradeData57Choice__1Builder getTradData();
		DerivativesTradeReportV03.DerivativesTradeReportV03Builder setRptHdr(TradeReportHeader4__1 rptHdr);
		DerivativesTradeReportV03.DerivativesTradeReportV03Builder setTradData(TradeData57Choice__1 tradData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("rptHdr"), processor, TradeReportHeader4__1.TradeReportHeader4__1Builder.class, getRptHdr());
			processRosetta(path.newSubPath("tradData"), processor, TradeData57Choice__1.TradeData57Choice__1Builder.class, getTradData());
		}
		

		DerivativesTradeReportV03.DerivativesTradeReportV03Builder prune();
	}

	/*********************** Immutable Implementation of DerivativesTradeReportV03  ***********************/
	class DerivativesTradeReportV03Impl implements DerivativesTradeReportV03 {
		private final TradeReportHeader4__1 rptHdr;
		private final TradeData57Choice__1 tradData;
		
		protected DerivativesTradeReportV03Impl(DerivativesTradeReportV03.DerivativesTradeReportV03Builder builder) {
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
		public TradeData57Choice__1 getTradData() {
			return tradData;
		}
		
		@Override
		public DerivativesTradeReportV03 build() {
			return this;
		}
		
		@Override
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder toBuilder() {
			DerivativesTradeReportV03.DerivativesTradeReportV03Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativesTradeReportV03.DerivativesTradeReportV03Builder builder) {
			ofNullable(getRptHdr()).ifPresent(builder::setRptHdr);
			ofNullable(getTradData()).ifPresent(builder::setTradData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeReportV03 _that = getType().cast(o);
		
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
			return "DerivativesTradeReportV03 {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativesTradeReportV03  ***********************/
	class DerivativesTradeReportV03BuilderImpl implements DerivativesTradeReportV03.DerivativesTradeReportV03Builder {
	
		protected TradeReportHeader4__1.TradeReportHeader4__1Builder rptHdr;
		protected TradeData57Choice__1.TradeData57Choice__1Builder tradData;
		
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
		public TradeData57Choice__1.TradeData57Choice__1Builder getTradData() {
			return tradData;
		}
		
		@Override
		public TradeData57Choice__1.TradeData57Choice__1Builder getOrCreateTradData() {
			TradeData57Choice__1.TradeData57Choice__1Builder result;
			if (tradData!=null) {
				result = tradData;
			}
			else {
				result = tradData = TradeData57Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("rptHdr")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("rptHdr")
		@Override
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder setRptHdr(TradeReportHeader4__1 _rptHdr) {
			this.rptHdr = _rptHdr == null ? null : _rptHdr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tradData")
		@Override
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder setTradData(TradeData57Choice__1 _tradData) {
			this.tradData = _tradData == null ? null : _tradData.toBuilder();
			return this;
		}
		
		@Override
		public DerivativesTradeReportV03 build() {
			return new DerivativesTradeReportV03.DerivativesTradeReportV03Impl(this);
		}
		
		@Override
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder prune() {
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
		public DerivativesTradeReportV03.DerivativesTradeReportV03Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativesTradeReportV03.DerivativesTradeReportV03Builder o = (DerivativesTradeReportV03.DerivativesTradeReportV03Builder) other;
			
			merger.mergeRosetta(getRptHdr(), o.getRptHdr(), this::setRptHdr);
			merger.mergeRosetta(getTradData(), o.getTradData(), this::setTradData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativesTradeReportV03 _that = getType().cast(o);
		
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
			return "DerivativesTradeReportV03Builder {" +
				"rptHdr=" + this.rptHdr + ", " +
				"tradData=" + this.tradData +
			'}';
		}
	}
}
