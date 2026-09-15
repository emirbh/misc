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
import iso20022.auth030.jfsa.meta.CommonTradeDataReport71__7Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport71__7", builder=CommonTradeDataReport71__7.CommonTradeDataReport71__7BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport71__7", model="iso20022", builder=CommonTradeDataReport71__7.CommonTradeDataReport71__7BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport71__7 extends RosettaModelObject {

	CommonTradeDataReport71__7Meta metaData = new CommonTradeDataReport71__7Meta();

	/*********************** Getter Methods  ***********************/
	ContractType15__2 getCtrctData();
	TradeTransaction50__7 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport71__7 build();
	
	CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder toBuilder();
	
	static CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder builder() {
		return new CommonTradeDataReport71__7.CommonTradeDataReport71__7BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport71__7> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport71__7> getType() {
		return CommonTradeDataReport71__7.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__2.class, getCtrctData());
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__7.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport71__7Builder extends CommonTradeDataReport71__7, RosettaModelObjectBuilder {
		ContractType15__2.ContractType15__2Builder getOrCreateCtrctData();
		@Override
		ContractType15__2.ContractType15__2Builder getCtrctData();
		TradeTransaction50__7.TradeTransaction50__7Builder getOrCreateTxData();
		@Override
		TradeTransaction50__7.TradeTransaction50__7Builder getTxData();
		CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder setCtrctData(ContractType15__2 ctrctData);
		CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder setTxData(TradeTransaction50__7 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ctrctData"), processor, ContractType15__2.ContractType15__2Builder.class, getCtrctData());
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__7.TradeTransaction50__7Builder.class, getTxData());
		}
		

		CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport71__7  ***********************/
	class CommonTradeDataReport71__7Impl implements CommonTradeDataReport71__7 {
		private final ContractType15__2 ctrctData;
		private final TradeTransaction50__7 txData;
		
		protected CommonTradeDataReport71__7Impl(CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder builder) {
			this.ctrctData = ofNullable(builder.getCtrctData()).map(f->f.build()).orElse(null);
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType15__2 getCtrctData() {
			return ctrctData;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__7 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport71__7 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder toBuilder() {
			CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder builder) {
			ofNullable(getCtrctData()).ifPresent(builder::setCtrctData);
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__7 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport71__7 {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport71__7  ***********************/
	class CommonTradeDataReport71__7BuilderImpl implements CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder {
	
		protected ContractType15__2.ContractType15__2Builder ctrctData;
		protected TradeTransaction50__7.TradeTransaction50__7Builder txData;
		
		@Override
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ctrctData")
		public ContractType15__2.ContractType15__2Builder getCtrctData() {
			return ctrctData;
		}
		
		@Override
		public ContractType15__2.ContractType15__2Builder getOrCreateCtrctData() {
			ContractType15__2.ContractType15__2Builder result;
			if (ctrctData!=null) {
				result = ctrctData;
			}
			else {
				result = ctrctData = ContractType15__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__7.TradeTransaction50__7Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction50__7.TradeTransaction50__7Builder getOrCreateTxData() {
			TradeTransaction50__7.TradeTransaction50__7Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction50__7.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ctrctData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ctrctData")
		@Override
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder setCtrctData(ContractType15__2 _ctrctData) {
			this.ctrctData = _ctrctData == null ? null : _ctrctData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder setTxData(TradeTransaction50__7 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__7 build() {
			return new CommonTradeDataReport71__7.CommonTradeDataReport71__7Impl(this);
		}
		
		@Override
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder prune() {
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
		public CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder o = (CommonTradeDataReport71__7.CommonTradeDataReport71__7Builder) other;
			
			merger.mergeRosetta(getCtrctData(), o.getCtrctData(), this::setCtrctData);
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__7 _that = getType().cast(o);
		
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
			return "CommonTradeDataReport71__7Builder {" +
				"ctrctData=" + this.ctrctData + ", " +
				"txData=" + this.txData +
			'}';
		}
	}
}
