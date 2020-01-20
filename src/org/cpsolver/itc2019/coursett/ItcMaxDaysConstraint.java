package org.cpsolver.itc2019.coursett;

import java.util.HashMap;
import java.util.Set;

import org.cpsolver.coursett.constraint.MaxDaysFlexibleConstraint;
import org.cpsolver.coursett.model.Lecture;
import org.cpsolver.coursett.model.Placement;
import org.cpsolver.ifs.assignment.Assignment;

/**
 * ITC 2019 penalization for the {@link MaxDaysFlexibleConstraint}
 * 
 * @author Tomas Muller
 */
public class ItcMaxDaysConstraint extends MaxDaysFlexibleConstraint{

	public ItcMaxDaysConstraint(Long id, String owner, String preference, String reference) {
		super(id, owner, preference, reference);
	}
	
	public double getCurrentPreference(Assignment<Lecture, Placement> assignment, Set<Placement> conflicts, HashMap<Lecture, Placement> assignments){
        if (isHard()) return 0;
        int violations = (int) getNrViolations(assignment, conflicts, assignments);
        if (violations == 0) return 0;
        return Math.abs(iPreference) * violations;
    }


}
