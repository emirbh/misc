package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.CommonTradeDataReport71__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommonTradeDataReport71__5", builder=CommonTradeDataReport71__5.CommonTradeDataReport71__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="CommonTradeDataReport71__5", model="iso20022", builder=CommonTradeDataReport71__5.CommonTradeDataReport71__5BuilderImpl.class, version="${project.version}")
public interface CommonTradeDataReport71__5 extends RosettaModelObject {

	CommonTradeDataReport71__5Meta metaData = new CommonTradeDataReport71__5Meta();

	/*********************** Getter Methods  ***********************/
	TradeTransaction50__5 getTxData();

	/*********************** Build Methods  ***********************/
	CommonTradeDataReport71__5 build();
	
	CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder toBuilder();
	
	static CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder builder() {
		return new CommonTradeDataReport71__5.CommonTradeDataReport71__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommonTradeDataReport71__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommonTradeDataReport71__5> getType() {
		return CommonTradeDataReport71__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__5.class, getTxData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommonTradeDataReport71__5Builder extends CommonTradeDataReport71__5, RosettaModelObjectBuilder {
		TradeTransaction50__5.TradeTransaction50__5Builder getOrCreateTxData();
		@Override
		TradeTransaction50__5.TradeTransaction50__5Builder getTxData();
		CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder setTxData(TradeTransaction50__5 txData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txData"), processor, TradeTransaction50__5.TradeTransaction50__5Builder.class, getTxData());
		}
		

		CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder prune();
	}

	/*********************** Immutable Implementation of CommonTradeDataReport71__5  ***********************/
	class CommonTradeDataReport71__5Impl implements CommonTradeDataReport71__5 {
		private final TradeTransaction50__5 txData;
		
		protected CommonTradeDataReport71__5Impl(CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder builder) {
			this.txData = ofNullable(builder.getTxData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__5 getTxData() {
			return txData;
		}
		
		@Override
		public CommonTradeDataReport71__5 build() {
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder toBuilder() {
			CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder builder) {
			ofNullable(getTxData()).ifPresent(builder::setTxData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__5 _that = getType().cast(o);
		
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__5 {" +
				"txData=" + this.txData +
			'}';
		}
	}

	/*********************** Builder Implementation of CommonTradeDataReport71__5  ***********************/
	class CommonTradeDataReport71__5BuilderImpl implements CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder {
	
		protected TradeTransaction50__5.TradeTransaction50__5Builder txData;
		
		@Override
		@RosettaAttribute("txData")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txData")
		public TradeTransaction50__5.TradeTransaction50__5Builder getTxData() {
			return txData;
		}
		
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder getOrCreateTxData() {
			TradeTransaction50__5.TradeTransaction50__5Builder result;
			if (txData!=null) {
				result = txData;
			}
			else {
				result = txData = TradeTransaction50__5.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txData")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txData")
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder setTxData(TradeTransaction50__5 _txData) {
			this.txData = _txData == null ? null : _txData.toBuilder();
			return this;
		}
		
		@Override
		public CommonTradeDataReport71__5 build() {
			return new CommonTradeDataReport71__5.CommonTradeDataReport71__5Impl(this);
		}
		
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder prune() {
			if (txData!=null && !txData.prune().hasData()) txData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxData()!=null && getTxData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder o = (CommonTradeDataReport71__5.CommonTradeDataReport71__5Builder) other;
			
			merger.mergeRosetta(getTxData(), o.getTxData(), this::setTxData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommonTradeDataReport71__5 _that = getType().cast(o);
		
			if (!Objects.equals(txData, _that.getTxData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txData != null ? txData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommonTradeDataReport71__5Builder {" +
				"txData=" + this.txData +
			'}';
		}
	}
}
