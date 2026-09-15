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
import iso20022.auth030.fca.meta.TradeNonConfirmation1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Identifies contract that is not confirmed.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeNonConfirmation1", builder=TradeNonConfirmation1.TradeNonConfirmation1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeNonConfirmation1", model="iso20022", builder=TradeNonConfirmation1.TradeNonConfirmation1BuilderImpl.class, version="${project.version}")
public interface TradeNonConfirmation1 extends RosettaModelObject {

	TradeNonConfirmation1Meta metaData = new TradeNonConfirmation1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies that the contract remains unconfirmed.
	 */
	TradeConfirmationType2Code getTp();

	/*********************** Build Methods  ***********************/
	TradeNonConfirmation1 build();
	
	TradeNonConfirmation1.TradeNonConfirmation1Builder toBuilder();
	
	static TradeNonConfirmation1.TradeNonConfirmation1Builder builder() {
		return new TradeNonConfirmation1.TradeNonConfirmation1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeNonConfirmation1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeNonConfirmation1> getType() {
		return TradeNonConfirmation1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), TradeConfirmationType2Code.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeNonConfirmation1Builder extends TradeNonConfirmation1, RosettaModelObjectBuilder {
		TradeNonConfirmation1.TradeNonConfirmation1Builder setTp(TradeConfirmationType2Code tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), TradeConfirmationType2Code.class, getTp(), this);
		}
		

		TradeNonConfirmation1.TradeNonConfirmation1Builder prune();
	}

	/*********************** Immutable Implementation of TradeNonConfirmation1  ***********************/
	class TradeNonConfirmation1Impl implements TradeNonConfirmation1 {
		private final TradeConfirmationType2Code tp;
		
		protected TradeNonConfirmation1Impl(TradeNonConfirmation1.TradeNonConfirmation1Builder builder) {
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType2Code getTp() {
			return tp;
		}
		
		@Override
		public TradeNonConfirmation1 build() {
			return this;
		}
		
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder toBuilder() {
			TradeNonConfirmation1.TradeNonConfirmation1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeNonConfirmation1.TradeNonConfirmation1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNonConfirmation1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNonConfirmation1 {" +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeNonConfirmation1  ***********************/
	class TradeNonConfirmation1BuilderImpl implements TradeNonConfirmation1.TradeNonConfirmation1Builder {
	
		protected TradeConfirmationType2Code tp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType2Code getTp() {
			return tp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder setTp(TradeConfirmationType2Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public TradeNonConfirmation1 build() {
			return new TradeNonConfirmation1.TradeNonConfirmation1Impl(this);
		}
		
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeNonConfirmation1.TradeNonConfirmation1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeNonConfirmation1.TradeNonConfirmation1Builder o = (TradeNonConfirmation1.TradeNonConfirmation1Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeNonConfirmation1 _that = getType().cast(o);
		
			if (!Objects.equals(tp, _that.getTp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tp != null ? tp.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeNonConfirmation1Builder {" +
				"tp=" + this.tp +
			'}';
		}
	}
}
