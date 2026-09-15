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
import iso20022.auth030.fca.meta.EnergyQuantityUnit2Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the units used to quantify an energy.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyQuantityUnit2Choice__1", builder=EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyQuantityUnit2Choice__1", model="iso20022", builder=EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1BuilderImpl.class, version="${project.version}")
public interface EnergyQuantityUnit2Choice__1 extends RosettaModelObject {

	EnergyQuantityUnit2Choice__1Meta metaData = new EnergyQuantityUnit2Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Energy quantity units, expressed as a code.
	 */
	EnergyQuantityUnit2Code getCd();

	/*********************** Build Methods  ***********************/
	EnergyQuantityUnit2Choice__1 build();
	
	EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder toBuilder();
	
	static EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder builder() {
		return new EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyQuantityUnit2Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyQuantityUnit2Choice__1> getType() {
		return EnergyQuantityUnit2Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cd"), EnergyQuantityUnit2Code.class, getCd(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyQuantityUnit2Choice__1Builder extends EnergyQuantityUnit2Choice__1, RosettaModelObjectBuilder {
		EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder setCd(EnergyQuantityUnit2Code cd);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("cd"), EnergyQuantityUnit2Code.class, getCd(), this);
		}
		

		EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of EnergyQuantityUnit2Choice__1  ***********************/
	class EnergyQuantityUnit2Choice__1Impl implements EnergyQuantityUnit2Choice__1 {
		private final EnergyQuantityUnit2Code cd;
		
		protected EnergyQuantityUnit2Choice__1Impl(EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder builder) {
			this.cd = builder.getCd();
		}
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public EnergyQuantityUnit2Code getCd() {
			return cd;
		}
		
		@Override
		public EnergyQuantityUnit2Choice__1 build() {
			return this;
		}
		
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder toBuilder() {
			EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder builder) {
			ofNullable(getCd()).ifPresent(builder::setCd);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyQuantityUnit2Choice__1 _that = getType().cast(o);
		
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
			return "EnergyQuantityUnit2Choice__1 {" +
				"cd=" + this.cd +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyQuantityUnit2Choice__1  ***********************/
	class EnergyQuantityUnit2Choice__1BuilderImpl implements EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder {
	
		protected EnergyQuantityUnit2Code cd;
		
		@Override
		@RosettaAttribute("cd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("cd")
		public EnergyQuantityUnit2Code getCd() {
			return cd;
		}
		
		@RosettaAttribute("cd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("cd")
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder setCd(EnergyQuantityUnit2Code _cd) {
			this.cd = _cd == null ? null : _cd;
			return this;
		}
		
		@Override
		public EnergyQuantityUnit2Choice__1 build() {
			return new EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Impl(this);
		}
		
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder o = (EnergyQuantityUnit2Choice__1.EnergyQuantityUnit2Choice__1Builder) other;
			
			
			merger.mergeBasic(getCd(), o.getCd(), this::setCd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyQuantityUnit2Choice__1 _that = getType().cast(o);
		
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
			return "EnergyQuantityUnit2Choice__1Builder {" +
				"cd=" + this.cd +
			'}';
		}
	}
}
