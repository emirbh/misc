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
import iso20022.auth030.hkma.tr.meta.DerivativeEvent6__6Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information related to derivative details.
 * @version ${project.version}
 */
@RosettaDataType(value="DerivativeEvent6__6", builder=DerivativeEvent6__6.DerivativeEvent6__6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="DerivativeEvent6__6", model="iso20022", builder=DerivativeEvent6__6.DerivativeEvent6__6BuilderImpl.class, version="${project.version}")
public interface DerivativeEvent6__6 extends RosettaModelObject {

	DerivativeEvent6__6Meta metaData = new DerivativeEvent6__6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Classification of derivative event type.
	 */
	DerivativeEventType3Code__4 getTp();

	/*********************** Build Methods  ***********************/
	DerivativeEvent6__6 build();
	
	DerivativeEvent6__6.DerivativeEvent6__6Builder toBuilder();
	
	static DerivativeEvent6__6.DerivativeEvent6__6Builder builder() {
		return new DerivativeEvent6__6.DerivativeEvent6__6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeEvent6__6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeEvent6__6> getType() {
		return DerivativeEvent6__6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__4.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeEvent6__6Builder extends DerivativeEvent6__6, RosettaModelObjectBuilder {
		DerivativeEvent6__6.DerivativeEvent6__6Builder setTp(DerivativeEventType3Code__4 tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), DerivativeEventType3Code__4.class, getTp(), this);
		}
		

		DerivativeEvent6__6.DerivativeEvent6__6Builder prune();
	}

	/*********************** Immutable Implementation of DerivativeEvent6__6  ***********************/
	class DerivativeEvent6__6Impl implements DerivativeEvent6__6 {
		private final DerivativeEventType3Code__4 tp;
		
		protected DerivativeEvent6__6Impl(DerivativeEvent6__6.DerivativeEvent6__6Builder builder) {
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public DerivativeEventType3Code__4 getTp() {
			return tp;
		}
		
		@Override
		public DerivativeEvent6__6 build() {
			return this;
		}
		
		@Override
		public DerivativeEvent6__6.DerivativeEvent6__6Builder toBuilder() {
			DerivativeEvent6__6.DerivativeEvent6__6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeEvent6__6.DerivativeEvent6__6Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__6 _that = getType().cast(o);
		
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
			return "DerivativeEvent6__6 {" +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeEvent6__6  ***********************/
	class DerivativeEvent6__6BuilderImpl implements DerivativeEvent6__6.DerivativeEvent6__6Builder {
	
		protected DerivativeEventType3Code__4 tp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public DerivativeEventType3Code__4 getTp() {
			return tp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public DerivativeEvent6__6.DerivativeEvent6__6Builder setTp(DerivativeEventType3Code__4 _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public DerivativeEvent6__6 build() {
			return new DerivativeEvent6__6.DerivativeEvent6__6Impl(this);
		}
		
		@Override
		public DerivativeEvent6__6.DerivativeEvent6__6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__6.DerivativeEvent6__6Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeEvent6__6.DerivativeEvent6__6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeEvent6__6.DerivativeEvent6__6Builder o = (DerivativeEvent6__6.DerivativeEvent6__6Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeEvent6__6 _that = getType().cast(o);
		
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
			return "DerivativeEvent6__6Builder {" +
				"tp=" + this.tp +
			'}';
		}
	}
}
