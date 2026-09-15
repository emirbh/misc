package iso20022.auth030.mas;

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
import iso20022.auth030.mas.meta.PaymentType5Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="PaymentType5Choice__1", builder=PaymentType5Choice__1.PaymentType5Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="PaymentType5Choice__1", model="iso20022", builder=PaymentType5Choice__1.PaymentType5Choice__1BuilderImpl.class, version="${project.version}")
public interface PaymentType5Choice__1 extends RosettaModelObject {

	PaymentType5Choice__1Meta metaData = new PaymentType5Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	PaymentType4Code getTp();

	/*********************** Build Methods  ***********************/
	PaymentType5Choice__1 build();
	
	PaymentType5Choice__1.PaymentType5Choice__1Builder toBuilder();
	
	static PaymentType5Choice__1.PaymentType5Choice__1Builder builder() {
		return new PaymentType5Choice__1.PaymentType5Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PaymentType5Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PaymentType5Choice__1> getType() {
		return PaymentType5Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), PaymentType4Code.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PaymentType5Choice__1Builder extends PaymentType5Choice__1, RosettaModelObjectBuilder {
		PaymentType5Choice__1.PaymentType5Choice__1Builder setTp(PaymentType4Code tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), PaymentType4Code.class, getTp(), this);
		}
		

		PaymentType5Choice__1.PaymentType5Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of PaymentType5Choice__1  ***********************/
	class PaymentType5Choice__1Impl implements PaymentType5Choice__1 {
		private final PaymentType4Code tp;
		
		protected PaymentType5Choice__1Impl(PaymentType5Choice__1.PaymentType5Choice__1Builder builder) {
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public PaymentType4Code getTp() {
			return tp;
		}
		
		@Override
		public PaymentType5Choice__1 build() {
			return this;
		}
		
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder toBuilder() {
			PaymentType5Choice__1.PaymentType5Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentType5Choice__1.PaymentType5Choice__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentType5Choice__1 _that = getType().cast(o);
		
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
			return "PaymentType5Choice__1 {" +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of PaymentType5Choice__1  ***********************/
	class PaymentType5Choice__1BuilderImpl implements PaymentType5Choice__1.PaymentType5Choice__1Builder {
	
		protected PaymentType4Code tp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public PaymentType4Code getTp() {
			return tp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder setTp(PaymentType4Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public PaymentType5Choice__1 build() {
			return new PaymentType5Choice__1.PaymentType5Choice__1Impl(this);
		}
		
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentType5Choice__1.PaymentType5Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentType5Choice__1.PaymentType5Choice__1Builder o = (PaymentType5Choice__1.PaymentType5Choice__1Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentType5Choice__1 _that = getType().cast(o);
		
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
			return "PaymentType5Choice__1Builder {" +
				"tp=" + this.tp +
			'}';
		}
	}
}
