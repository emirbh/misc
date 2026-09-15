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
import iso20022.auth030.fca.meta.AgreementType2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Classification of a master agreement.
 * @version ${project.version}
 */
@RosettaDataType(value="AgreementType2Choice__1", builder=AgreementType2Choice__1.AgreementType2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgreementType2Choice__1", model="iso20022", builder=AgreementType2Choice__1.AgreementType2Choice__1BuilderImpl.class, version="${project.version}")
public interface AgreementType2Choice__1 extends RosettaModelObject {

	AgreementType2Choice__1Meta metaData = new AgreementType2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Name of the identification scheme, in a coded form as published in an external list.
	 */
	MasterAgreementType2Code getTp();

	/*********************** Build Methods  ***********************/
	AgreementType2Choice__1 build();
	
	AgreementType2Choice__1.AgreementType2Choice__1Builder toBuilder();
	
	static AgreementType2Choice__1.AgreementType2Choice__1Builder builder() {
		return new AgreementType2Choice__1.AgreementType2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgreementType2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgreementType2Choice__1> getType() {
		return AgreementType2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tp"), MasterAgreementType2Code.class, getTp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgreementType2Choice__1Builder extends AgreementType2Choice__1, RosettaModelObjectBuilder {
		AgreementType2Choice__1.AgreementType2Choice__1Builder setTp(MasterAgreementType2Code tp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tp"), MasterAgreementType2Code.class, getTp(), this);
		}
		

		AgreementType2Choice__1.AgreementType2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of AgreementType2Choice__1  ***********************/
	class AgreementType2Choice__1Impl implements AgreementType2Choice__1 {
		private final MasterAgreementType2Code tp;
		
		protected AgreementType2Choice__1Impl(AgreementType2Choice__1.AgreementType2Choice__1Builder builder) {
			this.tp = builder.getTp();
		}
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public MasterAgreementType2Code getTp() {
			return tp;
		}
		
		@Override
		public AgreementType2Choice__1 build() {
			return this;
		}
		
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder toBuilder() {
			AgreementType2Choice__1.AgreementType2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgreementType2Choice__1.AgreementType2Choice__1Builder builder) {
			ofNullable(getTp()).ifPresent(builder::setTp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementType2Choice__1 _that = getType().cast(o);
		
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
			return "AgreementType2Choice__1 {" +
				"tp=" + this.tp +
			'}';
		}
	}

	/*********************** Builder Implementation of AgreementType2Choice__1  ***********************/
	class AgreementType2Choice__1BuilderImpl implements AgreementType2Choice__1.AgreementType2Choice__1Builder {
	
		protected MasterAgreementType2Code tp;
		
		@Override
		@RosettaAttribute("tp")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("tp")
		public MasterAgreementType2Code getTp() {
			return tp;
		}
		
		@RosettaAttribute("tp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tp")
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder setTp(MasterAgreementType2Code _tp) {
			this.tp = _tp == null ? null : _tp;
			return this;
		}
		
		@Override
		public AgreementType2Choice__1 build() {
			return new AgreementType2Choice__1.AgreementType2Choice__1Impl(this);
		}
		
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgreementType2Choice__1.AgreementType2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgreementType2Choice__1.AgreementType2Choice__1Builder o = (AgreementType2Choice__1.AgreementType2Choice__1Builder) other;
			
			
			merger.mergeBasic(getTp(), o.getTp(), this::setTp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgreementType2Choice__1 _that = getType().cast(o);
		
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
			return "AgreementType2Choice__1Builder {" +
				"tp=" + this.tp +
			'}';
		}
	}
}
