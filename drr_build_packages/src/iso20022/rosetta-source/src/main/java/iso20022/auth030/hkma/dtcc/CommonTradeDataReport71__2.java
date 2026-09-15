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
import iso20022.auth030.hkma.dtcc.meta.CommonTradeDataReport71__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract and transaction details.
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport71__2", builder=CommonTradeDataReport71__2.CommonTradeDataReport71__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport71__2", model="iso20022", builder=CommonTradeDataReport71__2.CommonTradeDataReport71__2BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport71__2 extends RosettaModelObject {

	CommonTradeDataReport71__2Meta metaData = new CommonTradeDataReport71__2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data related to a trade contract.
	 */
	ContractType15__1 getCtrctData();
	/**
	 * Data related to a trade transaction.
	 */
	TradeTransaction50__2 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport71__2 build();
	
	CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder toBuilder();
	
	static CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder builder() {
		return new CommonTradeDataReport71__2.CommonTradeDataReport71__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport71__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport71__2> getType() {
		return CommonTradeDataReport71__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__1.class, getCtrctData());
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__2.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport71__2Builder extends CommonTradeDataReport71__2, RosettaModelObjectBuilder {
		ContractType15__1.ContractType15__1Builder getOrCreateCtrctData();
		@Override
		ContractType15__1.ContractType15__1Builder getCtrctData();
		TradeTransaction50__2.TradeTransaction50__2Builder getOrCreateTxData();
		@Override
		TradeTransaction50__2.TradeTransaction50__2Builder getTxData();
		CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder setCtrctData(ContractType15__1 ctrctData);
		CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder setTxData(TradeTransaction50__2 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__1.ContractType15__1Builder.class, getCtrctData());
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__2.TradeTransaction50__2Builder.class, getTxData());
		}
		

		CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport71__2  ***********************/
	class CommonTradeDataReport71__2Impl implements CommonTradeDataReport71__2 {
		private final ContractType15__1 ctrctData;
		private final TradeTransaction50__2 txData;
		
		protected CommonTradeDataReport71__2Impl(CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder builder) {
			this.ctrctData = ofNullable(builder.getCtrctData()).map(f->f.build()).orElse(null);
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctData")
		public ContractType15__1 getCtrctData() {
			return ctrctData;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__2 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport71__2 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder toBuilder() {
			CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder builder) {
			ofNullable(getCtrctData()).ifPresent(builder::setCtrctData);
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctData, _that.getCtrctData())) return false;
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctData != null ? ctrctData.hashCode() : 0);
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__2 {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport71__2  ***********************/
	class CommonTradeDataReport71__2BuilderImpl implements CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder {
	
		protected ContractType15__1.ContractType15__1Builder ctrctData;
		protected TradeTransaction50__2.TradeTransaction50__2Builder txData;
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ctrctData")
		public ContractType15__1.ContractType15__1Builder getCtrctData() {
			return ctrctData;
		}
		
		@Override
		public ContractType15__1.ContractType15__1Builder getOrCreateCtrctData() {
			ContractType15__1.ContractType15__1Builder result;
			if (ctrctData!=null) {
				result = ctrctData;
			}
			else {
				result = ctrctData = ContractType15__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__2.TradeTransaction50__2Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction50__2.TradeTransaction50__2Builder getOrCreateTxData() {
			TradeTransaction50__2.TradeTransaction50__2Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction50__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ctrctData")
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder setCtrctData(ContractType15__1 _ctrctData) {
			this.ctrctData = _ctrctData == null ? null : _ctrctData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder setTxData(TradeTransaction50__2 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__2 build() {
			return new CommonTradeDataReport71__2.CommonTradeDataReport71__2Impl(this);
		}
		
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder prune() {
			if (ctrctData!=null && !ctrctData.prune().hasData()) ctrctData = null;
			if (txData!=null && !txData.prune().hasData()) txData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtrctData()!=null && getCtrctData().hasData()) return true;
			if (getTxData()!=null && getTxData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder o = (CommonTradeDataReport71__2.CommonTradeDataReport71__2Builder) other;
			
			merger.mergeRosetta(getCtrctData(), o.getCtrctData(), this::setCtrctData);
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__2 _that = getType().cast(o);
		
			if (!Objects.equals(ctrctData, _that.getCtrctData())) return false;
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctrctData != null ? ctrctData.hashCode() : 0);
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__2Builder {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}
}
