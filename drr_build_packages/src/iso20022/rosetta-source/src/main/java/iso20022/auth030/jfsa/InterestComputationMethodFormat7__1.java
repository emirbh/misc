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
import iso20022.auth030.jfsa.meta.InterestComputationMethodFormat7__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InterestComputationMethodFormat7__1", builder=InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="InterestComputationMethodFormat7__1", model="iso20022", builder=InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1BuilderImpl.class, version="${project.version}")
public interface InterestComputationMethodFormat7__1 extends RosettaModelObject {

	InterestComputationMethodFormat7__1Meta metaData = new InterestComputationMethodFormat7__1Meta();

	/*********************** Getter Methods  ***********************/
	InterestComputationMethod4Code getCd();

	/*********************** Build Methods  ***********************/
	InterestComputationMethodFormat7__1 build();
	
	InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder toBuilder();
	
	static InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder builder() {
		return new InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestComputationMethodFormat7__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends InterestComputationMethodFormat7__1> getType() {
		return InterestComputationMethodFormat7__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), InterestComputationMethod4Code.class, getCd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestComputationMethodFormat7__1Builder extends InterestComputationMethodFormat7__1, RosettaModelObjectBuilder {
		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder setCd(InterestComputationMethod4Code cd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), InterestComputationMethod4Code.class, getCd(), this);
		}
		

		InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder prune();
	}

	/*********************** Immutable Implementation of InterestComputationMethodFormat7__1  ***********************/
	class InterestComputationMethodFormat7__1Impl implements InterestComputationMethodFormat7__1 {
		private final InterestComputationMethod4Code cd;
		
		protected InterestComputationMethodFormat7__1Impl(InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder builder) {
			this.cd = builder.getCd();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public InterestComputationMethod4Code getCd() {
			return cd;
		}
		
		@Override
		public InterestComputationMethodFormat7__1 build() {
			return this;
		}
		
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder toBuilder() {
			InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestComputationMethodFormat7__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestComputationMethodFormat7__1 {" +
				"cd=" + this.cd +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestComputationMethodFormat7__1  ***********************/
	class InterestComputationMethodFormat7__1BuilderImpl implements InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder {
	
		protected InterestComputationMethod4Code cd;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public InterestComputationMethod4Code getCd() {
			return cd;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder setCd(InterestComputationMethod4Code _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@Override
		public InterestComputationMethodFormat7__1 build() {
			return new InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Impl(this);
		}
		
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder o = (InterestComputationMethodFormat7__1.InterestComputationMethodFormat7__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestComputationMethodFormat7__1 _that = getType().cast(o);
		
			if (!Objects.equals(cd, _that.getCd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cd != null ? cd.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestComputationMethodFormat7__1Builder {" +
				"cd=" + this.cd +
			'}';
		}
	}
}
