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
import iso20022.auth030.fca.meta.CommonTradeDataReport69__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to contract and transaction details.
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport69__1", builder=CommonTradeDataReport69__1.CommonTradeDataReport69__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport69__1", model="iso20022", builder=CommonTradeDataReport69__1.CommonTradeDataReport69__1BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport69__1 extends RosettaModelObject {

	CommonTradeDataReport69__1Meta metaData = new CommonTradeDataReport69__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Data related to a trade contract.
	 */
	ContractType14__1 getCtrctData();
	/**
	 * Data related to a trade transaction.
	 */
	TradeTransaction49__1 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport69__1 build();
	
	CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder toBuilder();
	
	static CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder builder() {
		return new CommonTradeDataReport69__1.CommonTradeDataReport69__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport69__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport69__1> getType() {
		return CommonTradeDataReport69__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctData"), processor, ContractType14__1.class, getCtrctData());
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__1.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport69__1Builder extends CommonTradeDataReport69__1, RosettaModelObjectBuilder {
		ContractType14__1.ContractType14__1Builder getOrCreateCtrctData();
		@Override
		ContractType14__1.ContractType14__1Builder getCtrctData();
		TradeTransaction49__1.TradeTransaction49__1Builder getOrCreateTxData();
		@Override
		TradeTransaction49__1.TradeTransaction49__1Builder getTxData();
		CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder setCtrctData(ContractType14__1 ctrctData);
		CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder setTxData(TradeTransaction49__1 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctData"), processor, ContractType14__1.ContractType14__1Builder.class, getCtrctData());
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction49__1.TradeTransaction49__1Builder.class, getTxData());
		}
		

		CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport69__1  ***********************/
	class CommonTradeDataReport69__1Impl implements CommonTradeDataReport69__1 {
		private final ContractType14__1 ctrctData;
		private final TradeTransaction49__1 txData;
		
		protected CommonTradeDataReport69__1Impl(CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder builder) {
			this.ctrctData = ofNullable(builder.getCtrctData()).map(f->f.build()).orElse(null);
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType14__1 getCtrctData() {
			return ctrctData;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__1 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport69__1 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder toBuilder() {
			CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder builder) {
			ofNullable(getCtrctData()).ifPresent(builder::setCtrctData);
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__1 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport69__1 {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport69__1  ***********************/
	class CommonTradeDataReport69__1BuilderImpl implements CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder {
	
		protected ContractType14__1.ContractType14__1Builder ctrctData;
		protected TradeTransaction49__1.TradeTransaction49__1Builder txData;
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType14__1.ContractType14__1Builder getCtrctData() {
			return ctrctData;
		}
		
		@Override
		public ContractType14__1.ContractType14__1Builder getOrCreateCtrctData() {
			ContractType14__1.ContractType14__1Builder result;
			if (ctrctData!=null) {
				result = ctrctData;
			}
			else {
				result = ctrctData = ContractType14__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction49__1.TradeTransaction49__1Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction49__1.TradeTransaction49__1Builder getOrCreateTxData() {
			TradeTransaction49__1.TradeTransaction49__1Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction49__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrctData")
		@Override
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder setCtrctData(ContractType14__1 _ctrctData) {
			this.ctrctData = _ctrctData == null ? null : _ctrctData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder setTxData(TradeTransaction49__1 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport69__1 build() {
			return new CommonTradeDataReport69__1.CommonTradeDataReport69__1Impl(this);
		}
		
		@Override
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder prune() {
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
		public CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder o = (CommonTradeDataReport69__1.CommonTradeDataReport69__1Builder) other;
			
			merger.mergeRosetta(getCtrctData(), o.getCtrctData(), this::setCtrctData);
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport69__1 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport69__1Builder {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}
}
