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
import iso20022.auth030.hkma.tr.meta.TradeConfirmation5__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies time and type of contract confirmation.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeConfirmation5__1", builder=TradeConfirmation5__1.TradeConfirmation5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeConfirmation5__1", model="iso20022", builder=TradeConfirmation5__1.TradeConfirmation5__1BuilderImpl.class, version="${project.version}")
public interface TradeConfirmation5__1 extends RosettaModelObject {

	TradeConfirmation5__1Meta metaData = new TradeConfirmation5__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies whether the contract was confirmed electronically or non-electronically.
	 */
	TradeConfirmationType1Code getTp();

	/*********************** Build Methods  ***********************/
	TradeConfirmation5__1 build();
	
	TradeConfirmation5__1.TradeConfirmation5__1Builder toBuilder();
	
	static TradeConfirmation5__1.TradeConfirmation5__1Builder builder() {
		return new TradeConfirmation5__1.TradeConfirmation5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeConfirmation5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeConfirmation5__1> getType() {
		return TradeConfirmation5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeConfirmation5__1Builder extends TradeConfirmation5__1, RosettaModelObjectBuilder {
		TradeConfirmation5__1.TradeConfirmation5__1Builder setTp(TradeConfirmationType1Code tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), TradeConfirmationType1Code.class, getTp(), this);
		}
		

		TradeConfirmation5__1.TradeConfirmation5__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeConfirmation5__1  ***********************/
	class TradeConfirmation5__1Impl implements TradeConfirmation5__1 {
		private final TradeConfirmationType1Code tp;
		
		protected TradeConfirmation5__1Impl(TradeConfirmation5__1.TradeConfirmation5__1Builder builder) {
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@Override
		public TradeConfirmation5__1 build() {
			return this;
		}
		
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder toBuilder() {
			TradeConfirmation5__1.TradeConfirmation5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeConfirmation5__1.TradeConfirmation5__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation5__1 _that = getType().cast(o);
		
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
			return "TradeConfirmation5__1 {" +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeConfirmation5__1  ***********************/
	class TradeConfirmation5__1BuilderImpl implements TradeConfirmation5__1.TradeConfirmation5__1Builder {
	
		protected TradeConfirmationType1Code tp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public TradeConfirmationType1Code getTp() {
			return tp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder setTp(TradeConfirmationType1Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public TradeConfirmation5__1 build() {
			return new TradeConfirmation5__1.TradeConfirmation5__1Impl(this);
		}
		
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeConfirmation5__1.TradeConfirmation5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeConfirmation5__1.TradeConfirmation5__1Builder o = (TradeConfirmation5__1.TradeConfirmation5__1Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeConfirmation5__1 _that = getType().cast(o);
		
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
			return "TradeConfirmation5__1Builder {" +
				"tp=" + this.tp +
			'}';
		}
	}
}
