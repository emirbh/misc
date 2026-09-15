package iso20022.auth030.asic;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.asic.meta.NotionalQuantityLegs5__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalQuantityLegs5__1", builder=NotionalQuantityLegs5__1.NotionalQuantityLegs5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalQuantityLegs5__1", model="iso20022", builder=NotionalQuantityLegs5__1.NotionalQuantityLegs5__1BuilderImpl.class, version="${project.version}")
public interface NotionalQuantityLegs5__1 extends RosettaModelObject {

	NotionalQuantityLegs5__1Meta metaData = new NotionalQuantityLegs5__1Meta();

	/*********************** Getter Methods  ***********************/
	NotionalQuantity9__1 getFrstLeg();
	NotionalQuantity9__1 getScndLeg();

	/*********************** Build Methods  ***********************/
	NotionalQuantityLegs5__1 build();
	
	NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder toBuilder();
	
	static NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder builder() {
		return new NotionalQuantityLegs5__1.NotionalQuantityLegs5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantityLegs5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantityLegs5__1> getType() {
		return NotionalQuantityLegs5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("frstLeg"), processor, NotionalQuantity9__1.class, getFrstLeg());
		processRosetta(path.newSubPath("scndLeg"), processor, NotionalQuantity9__1.class, getScndLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantityLegs5__1Builder extends NotionalQuantityLegs5__1, RosettaModelObjectBuilder {
		NotionalQuantity9__1.NotionalQuantity9__1Builder getOrCreateFrstLeg();
		@Override
		NotionalQuantity9__1.NotionalQuantity9__1Builder getFrstLeg();
		NotionalQuantity9__1.NotionalQuantity9__1Builder getOrCreateScndLeg();
		@Override
		NotionalQuantity9__1.NotionalQuantity9__1Builder getScndLeg();
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder setFrstLeg(NotionalQuantity9__1 frstLeg);
		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder setScndLeg(NotionalQuantity9__1 scndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("frstLeg"), processor, NotionalQuantity9__1.NotionalQuantity9__1Builder.class, getFrstLeg());
			processRosetta(path.newSubPath("scndLeg"), processor, NotionalQuantity9__1.NotionalQuantity9__1Builder.class, getScndLeg());
		}
		

		NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantityLegs5__1  ***********************/
	class NotionalQuantityLegs5__1Impl implements NotionalQuantityLegs5__1 {
		private final NotionalQuantity9__1 frstLeg;
		private final NotionalQuantity9__1 scndLeg;
		
		protected NotionalQuantityLegs5__1Impl(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder builder) {
			this.frstLeg = ofNullable(builder.getFrstLeg()).map(f->f.build()).orElse(null);
			this.scndLeg = ofNullable(builder.getScndLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalQuantity9__1 getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalQuantity9__1 getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalQuantityLegs5__1 build() {
			return this;
		}
		
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder toBuilder() {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder builder) {
			ofNullable(getFrstLeg()).ifPresent(builder::setFrstLeg);
			ofNullable(getScndLeg()).ifPresent(builder::setScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityLegs5__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityLegs5__1 {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantityLegs5__1  ***********************/
	class NotionalQuantityLegs5__1BuilderImpl implements NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder {
	
		protected NotionalQuantity9__1.NotionalQuantity9__1Builder frstLeg;
		protected NotionalQuantity9__1.NotionalQuantity9__1Builder scndLeg;
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalQuantity9__1.NotionalQuantity9__1Builder getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		public NotionalQuantity9__1.NotionalQuantity9__1Builder getOrCreateFrstLeg() {
			NotionalQuantity9__1.NotionalQuantity9__1Builder result;
			if (frstLeg!=null) {
				result = frstLeg;
			}
			else {
				result = frstLeg = NotionalQuantity9__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalQuantity9__1.NotionalQuantity9__1Builder getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalQuantity9__1.NotionalQuantity9__1Builder getOrCreateScndLeg() {
			NotionalQuantity9__1.NotionalQuantity9__1Builder result;
			if (scndLeg!=null) {
				result = scndLeg;
			}
			else {
				result = scndLeg = NotionalQuantity9__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstLeg")
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder setFrstLeg(NotionalQuantity9__1 _frstLeg) {
			this.frstLeg = _frstLeg == null ? null : _frstLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndLeg")
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder setScndLeg(NotionalQuantity9__1 _scndLeg) {
			this.scndLeg = _scndLeg == null ? null : _scndLeg.toBuilder();
			return this;
		}
		
		@Override
		public NotionalQuantityLegs5__1 build() {
			return new NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Impl(this);
		}
		
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder prune() {
			if (frstLeg!=null && !frstLeg.prune().hasData()) frstLeg = null;
			if (scndLeg!=null && !scndLeg.prune().hasData()) scndLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrstLeg()!=null && getFrstLeg().hasData()) return true;
			if (getScndLeg()!=null && getScndLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder o = (NotionalQuantityLegs5__1.NotionalQuantityLegs5__1Builder) other;
			
			merger.mergeRosetta(getFrstLeg(), o.getFrstLeg(), this::setFrstLeg);
			merger.mergeRosetta(getScndLeg(), o.getScndLeg(), this::setScndLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityLegs5__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantityLegs5__1Builder {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}
}
