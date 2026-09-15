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
import iso20022.auth030.hkma.dtcc.meta.TradeTransaction50__5Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details of the trade transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeTransaction50__5", builder=TradeTransaction50__5.TradeTransaction50__5BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeTransaction50__5", model="iso20022", builder=TradeTransaction50__5.TradeTransaction50__5BuilderImpl.class, version="${project.version}")
public interface TradeTransaction50__5 extends RosettaModelObject {

	TradeTransaction50__5Meta metaData = new TradeTransaction50__5Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Choice between a Unique Transaction Identifier (UTI) or a proprietary identifier as agreed with the counterparty.
	 */
	UniqueTransactionIdentifier2Choice__1 getTxId();

	/*********************** Build Methods  ***********************/
	TradeTransaction50__5 build();
	
	TradeTransaction50__5.TradeTransaction50__5Builder toBuilder();
	
	static TradeTransaction50__5.TradeTransaction50__5Builder builder() {
		return new TradeTransaction50__5.TradeTransaction50__5BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeTransaction50__5> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeTransaction50__5> getType() {
		return TradeTransaction50__5.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.class, getTxId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeTransaction50__5Builder extends TradeTransaction50__5, RosettaModelObjectBuilder {
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId();
		@Override
		UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId();
		TradeTransaction50__5.TradeTransaction50__5Builder setTxId(UniqueTransactionIdentifier2Choice__1 txId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("txId"), processor, UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder.class, getTxId());
		}
		

		TradeTransaction50__5.TradeTransaction50__5Builder prune();
	}

	/*********************** Immutable Implementation of TradeTransaction50__5  ***********************/
	class TradeTransaction50__5Impl implements TradeTransaction50__5 {
		private final UniqueTransactionIdentifier2Choice__1 txId;
		
		protected TradeTransaction50__5Impl(TradeTransaction50__5.TradeTransaction50__5Builder builder) {
			this.txId = ofNullable(builder.getTxId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1 getTxId() {
			return txId;
		}
		
		@Override
		public TradeTransaction50__5 build() {
			return this;
		}
		
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder toBuilder() {
			TradeTransaction50__5.TradeTransaction50__5Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeTransaction50__5.TradeTransaction50__5Builder builder) {
			ofNullable(getTxId()).ifPresent(builder::setTxId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__5 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__5 {" +
				"txId=" + this.txId +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeTransaction50__5  ***********************/
	class TradeTransaction50__5BuilderImpl implements TradeTransaction50__5.TradeTransaction50__5Builder {
	
		protected UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder txId;
		
		@Override
		@RosettaAttribute("txId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("txId")
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getTxId() {
			return txId;
		}
		
		@Override
		public UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder getOrCreateTxId() {
			UniqueTransactionIdentifier2Choice__1.UniqueTransactionIdentifier2Choice__1Builder result;
			if (txId!=null) {
				result = txId;
			}
			else {
				result = txId = UniqueTransactionIdentifier2Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("txId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("txId")
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder setTxId(UniqueTransactionIdentifier2Choice__1 _txId) {
			this.txId = _txId == null ? null : _txId.toBuilder();
			return this;
		}
		
		@Override
		public TradeTransaction50__5 build() {
			return new TradeTransaction50__5.TradeTransaction50__5Impl(this);
		}
		
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder prune() {
			if (txId!=null && !txId.prune().hasData()) txId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTxId()!=null && getTxId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeTransaction50__5.TradeTransaction50__5Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeTransaction50__5.TradeTransaction50__5Builder o = (TradeTransaction50__5.TradeTransaction50__5Builder) other;
			
			merger.mergeRosetta(getTxId(), o.getTxId(), this::setTxId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeTransaction50__5 _that = getType().cast(o);
		
			if (!Objects.equals(txId, _that.getTxId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (txId != null ? txId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeTransaction50__5Builder {" +
				"txId=" + this.txId +
			'}';
		}
	}
}
