package iso20022.auth030.jfsa;

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
import iso20022.auth030.jfsa.meta.NotionalQuantityLegs5__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalQuantityLegs5__2", builder=NotionalQuantityLegs5__2.NotionalQuantityLegs5__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalQuantityLegs5__2", model="iso20022", builder=NotionalQuantityLegs5__2.NotionalQuantityLegs5__2BuilderImpl.class, version="${project.version}")
public interface NotionalQuantityLegs5__2 extends RosettaModelObject {

	NotionalQuantityLegs5__2Meta metaData = new NotionalQuantityLegs5__2Meta();

	/*********************** Getter Methods  ***********************/
	NotionalQuantity9__2 getFrstLeg();
	NotionalQuantity9__2 getScndLeg();

	/*********************** Build Methods  ***********************/
	NotionalQuantityLegs5__2 build();
	
	NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder toBuilder();
	
	static NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder builder() {
		return new NotionalQuantityLegs5__2.NotionalQuantityLegs5__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantityLegs5__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantityLegs5__2> getType() {
		return NotionalQuantityLegs5__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("frstLeg"), processor, NotionalQuantity9__2.class, getFrstLeg());
		processRosetta(path.newSubPath("scndLeg"), processor, NotionalQuantity9__2.class, getScndLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantityLegs5__2Builder extends NotionalQuantityLegs5__2, RosettaModelObjectBuilder {
		NotionalQuantity9__2.NotionalQuantity9__2Builder getOrCreateFrstLeg();
		@Override
		NotionalQuantity9__2.NotionalQuantity9__2Builder getFrstLeg();
		NotionalQuantity9__2.NotionalQuantity9__2Builder getOrCreateScndLeg();
		@Override
		NotionalQuantity9__2.NotionalQuantity9__2Builder getScndLeg();
		NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder setFrstLeg(NotionalQuantity9__2 frstLeg);
		NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder setScndLeg(NotionalQuantity9__2 scndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("frstLeg"), processor, NotionalQuantity9__2.NotionalQuantity9__2Builder.class, getFrstLeg());
			processRosetta(path.newSubPath("scndLeg"), processor, NotionalQuantity9__2.NotionalQuantity9__2Builder.class, getScndLeg());
		}
		

		NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantityLegs5__2  ***********************/
	class NotionalQuantityLegs5__2Impl implements NotionalQuantityLegs5__2 {
		private final NotionalQuantity9__2 frstLeg;
		private final NotionalQuantity9__2 scndLeg;
		
		protected NotionalQuantityLegs5__2Impl(NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder builder) {
			this.frstLeg = ofNullable(builder.getFrstLeg()).map(f->f.build()).orElse(null);
			this.scndLeg = ofNullable(builder.getScndLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalQuantity9__2 getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalQuantity9__2 getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalQuantityLegs5__2 build() {
			return this;
		}
		
		@Override
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder toBuilder() {
			NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder builder) {
			ofNullable(getFrstLeg()).ifPresent(builder::setFrstLeg);
			ofNullable(getScndLeg()).ifPresent(builder::setScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityLegs5__2 _that = getType().cast(o);
		
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
			return "NotionalQuantityLegs5__2 {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantityLegs5__2  ***********************/
	class NotionalQuantityLegs5__2BuilderImpl implements NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder {
	
		protected NotionalQuantity9__2.NotionalQuantity9__2Builder frstLeg;
		protected NotionalQuantity9__2.NotionalQuantity9__2Builder scndLeg;
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalQuantity9__2.NotionalQuantity9__2Builder getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder getOrCreateFrstLeg() {
			NotionalQuantity9__2.NotionalQuantity9__2Builder result;
			if (frstLeg!=null) {
				result = frstLeg;
			}
			else {
				result = frstLeg = NotionalQuantity9__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalQuantity9__2.NotionalQuantity9__2Builder getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder getOrCreateScndLeg() {
			NotionalQuantity9__2.NotionalQuantity9__2Builder result;
			if (scndLeg!=null) {
				result = scndLeg;
			}
			else {
				result = scndLeg = NotionalQuantity9__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstLeg")
		@Override
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder setFrstLeg(NotionalQuantity9__2 _frstLeg) {
			this.frstLeg = _frstLeg == null ? null : _frstLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndLeg")
		@Override
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder setScndLeg(NotionalQuantity9__2 _scndLeg) {
			this.scndLeg = _scndLeg == null ? null : _scndLeg.toBuilder();
			return this;
		}
		
		@Override
		public NotionalQuantityLegs5__2 build() {
			return new NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Impl(this);
		}
		
		@Override
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder prune() {
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
		public NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder o = (NotionalQuantityLegs5__2.NotionalQuantityLegs5__2Builder) other;
			
			merger.mergeRosetta(getFrstLeg(), o.getFrstLeg(), this::setFrstLeg);
			merger.mergeRosetta(getScndLeg(), o.getScndLeg(), this::setScndLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantityLegs5__2 _that = getType().cast(o);
		
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
			return "NotionalQuantityLegs5__2Builder {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}
}
