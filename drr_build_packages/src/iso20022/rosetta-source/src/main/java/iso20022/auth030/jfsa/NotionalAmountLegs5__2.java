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
import iso20022.auth030.jfsa.meta.NotionalAmountLegs5__2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalAmountLegs5__2", builder=NotionalAmountLegs5__2.NotionalAmountLegs5__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalAmountLegs5__2", model="iso20022", builder=NotionalAmountLegs5__2.NotionalAmountLegs5__2BuilderImpl.class, version="${project.version}")
public interface NotionalAmountLegs5__2 extends RosettaModelObject {

	NotionalAmountLegs5__2Meta metaData = new NotionalAmountLegs5__2Meta();

	/*********************** Getter Methods  ***********************/
	NotionalAmount5__2 getFrstLeg();
	NotionalAmount6__2 getScndLeg();

	/*********************** Build Methods  ***********************/
	NotionalAmountLegs5__2 build();
	
	NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder toBuilder();
	
	static NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder builder() {
		return new NotionalAmountLegs5__2.NotionalAmountLegs5__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmountLegs5__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalAmountLegs5__2> getType() {
		return NotionalAmountLegs5__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("frstLeg"), processor, NotionalAmount5__2.class, getFrstLeg());
		processRosetta(path.newSubPath("scndLeg"), processor, NotionalAmount6__2.class, getScndLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmountLegs5__2Builder extends NotionalAmountLegs5__2, RosettaModelObjectBuilder {
		NotionalAmount5__2.NotionalAmount5__2Builder getOrCreateFrstLeg();
		@Override
		NotionalAmount5__2.NotionalAmount5__2Builder getFrstLeg();
		NotionalAmount6__2.NotionalAmount6__2Builder getOrCreateScndLeg();
		@Override
		NotionalAmount6__2.NotionalAmount6__2Builder getScndLeg();
		NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder setFrstLeg(NotionalAmount5__2 frstLeg);
		NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder setScndLeg(NotionalAmount6__2 scndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("frstLeg"), processor, NotionalAmount5__2.NotionalAmount5__2Builder.class, getFrstLeg());
			processRosetta(path.newSubPath("scndLeg"), processor, NotionalAmount6__2.NotionalAmount6__2Builder.class, getScndLeg());
		}
		

		NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder prune();
	}

	/*********************** Immutable Implementation of NotionalAmountLegs5__2  ***********************/
	class NotionalAmountLegs5__2Impl implements NotionalAmountLegs5__2 {
		private final NotionalAmount5__2 frstLeg;
		private final NotionalAmount6__2 scndLeg;
		
		protected NotionalAmountLegs5__2Impl(NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder builder) {
			this.frstLeg = ofNullable(builder.getFrstLeg()).map(f->f.build()).orElse(null);
			this.scndLeg = ofNullable(builder.getScndLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalAmount5__2 getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalAmount6__2 getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalAmountLegs5__2 build() {
			return this;
		}
		
		@Override
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder toBuilder() {
			NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder builder) {
			ofNullable(getFrstLeg()).ifPresent(builder::setFrstLeg);
			ofNullable(getScndLeg()).ifPresent(builder::setScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmountLegs5__2 _that = getType().cast(o);
		
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
			return "NotionalAmountLegs5__2 {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalAmountLegs5__2  ***********************/
	class NotionalAmountLegs5__2BuilderImpl implements NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder {
	
		protected NotionalAmount5__2.NotionalAmount5__2Builder frstLeg;
		protected NotionalAmount6__2.NotionalAmount6__2Builder scndLeg;
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("frstLeg")
		public NotionalAmount5__2.NotionalAmount5__2Builder getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		public NotionalAmount5__2.NotionalAmount5__2Builder getOrCreateFrstLeg() {
			NotionalAmount5__2.NotionalAmount5__2Builder result;
			if (frstLeg!=null) {
				result = frstLeg;
			}
			else {
				result = frstLeg = NotionalAmount5__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalAmount6__2.NotionalAmount6__2Builder getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalAmount6__2.NotionalAmount6__2Builder getOrCreateScndLeg() {
			NotionalAmount6__2.NotionalAmount6__2Builder result;
			if (scndLeg!=null) {
				result = scndLeg;
			}
			else {
				result = scndLeg = NotionalAmount6__2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("frstLeg")
		@Override
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder setFrstLeg(NotionalAmount5__2 _frstLeg) {
			this.frstLeg = _frstLeg == null ? null : _frstLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndLeg")
		@Override
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder setScndLeg(NotionalAmount6__2 _scndLeg) {
			this.scndLeg = _scndLeg == null ? null : _scndLeg.toBuilder();
			return this;
		}
		
		@Override
		public NotionalAmountLegs5__2 build() {
			return new NotionalAmountLegs5__2.NotionalAmountLegs5__2Impl(this);
		}
		
		@Override
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder prune() {
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
		public NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder o = (NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder) other;
			
			merger.mergeRosetta(getFrstLeg(), o.getFrstLeg(), this::setFrstLeg);
			merger.mergeRosetta(getScndLeg(), o.getScndLeg(), this::setScndLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmountLegs5__2 _that = getType().cast(o);
		
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
			return "NotionalAmountLegs5__2Builder {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}
}
